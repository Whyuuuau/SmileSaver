const db = require("../models");
const config = require("../config/auth.config");
const User = db.user;

const Op = db.Sequelize.Op;

var jwt = require("jsonwebtoken");
var bcrypt = require("bcryptjs");

exports.signup = (req, res) => {
  // Save User to Database
  User.create({
    username: req.body.username,
    email: req.body.email,
    password: bcrypt.hashSync(req.body.password, 8)
  })
    .then(user => {
      res.send({ message: "User was registered successfully!" });
    })
    .catch(err => {
      res.status(500).send({ message: err.message });
    });
};

exports.signin = (req, res) => {
  User.findOne({
    where: {
      username: req.body.username
    }
  })
    .then(user => {
      if (!user) {
        return res.status(404).send({ message: "User Not found." });
      }

      var passwordIsValid = bcrypt.compareSync(
        req.body.password,
        user.password
      );

      if (!passwordIsValid) {
        return res.status(401).send({
          accessToken: null,
          message: "Invalid Password!"
        });
      }

      const token = jwt.sign({ id: user.id },
                              config.secret,
                              {
                                algorithm: 'HS256',
                                allowInsecureKeySizes: true,
                                expiresIn: 86400, // 24 hours
                              });

      var authorities = [];
        res.status(200).send({
          id: user.id,
          username: user.username,
          email: user.email,
          accessToken: token
        });
    })
    .catch(err => {
      res.status(500).send({ message: err.message });
    });
};

exports.updateUser = (req, res) => {
  const userId = req.params.id;
  User.findByPk(userId)
    .then(user => {
      if (!user) {
        return res.status(404).send({ message: "User Not found." });
      }
      user.update({
        username: req.body.username || user.username,
        email: req.body.email || user.email,
        password: req.body.password
          ? bcrypt.hashSync(req.body.password, 8)
          : user.password,
      })
        .then(updatedUser => {
          res.status(200).send({
            id: updatedUser.id,
            username: updatedUser.username,
            email: updatedUser.email,
            message: "User updated successfully!",
          });
        })
        .catch(err => {
          res.status(500).send({ message: err.message });
        });
    })
    .catch(err => {
      res.status(500).send({ message: err.message });
    });
};

exports.deleteUser = (req, res) => {
  const userId = req.params.id;
  User.findByPk(userId)
    .then(user => {
      if (!user) {
        return res.status(404).send({ message: "User Not found." });
      }
      user.destroy()
        .then(() => {
          res.status(200).send({ message: "User deleted successfully!" });
        })
        .catch(err => {
          res.status(500).send({ message: err.message });
        });
    })
};

exports.deleteAllUsers = (req, res) => {
  User.destroy({ where: {} })
    .then(() => {
      res.status(200).send({ message: "All users deleted successfully!" });
    })
    .catch(err => {
      res.status(500).send({ message: err.message });
    });
};
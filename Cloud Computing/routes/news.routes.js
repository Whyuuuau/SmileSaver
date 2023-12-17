// routes/newsRoutes.js
const express = require('express');
const router = express.Router();
const newsController = require('../controllers/news.controller');
const validateNews = require('../middleware/validateNews');

module.exports = function(app) {
  app.use(function(req, res, next) {
    res.header(
      "Access-Control-Allow-Headers",
      "x-access-token, Origin, Content-Type, Accept"
    );
    next();
  });

  app.post("/api/new/news", validateNews, newsController.createNews)
  app.get("/api/news/all", newsController.getAllNews);
};
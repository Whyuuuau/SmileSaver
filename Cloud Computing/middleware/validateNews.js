const db = require("../models");
const News = db.news;

// middleware/validateNews.js
const validateNews = (req, res, next) => {
  const { title, content } = req.body;

  // Validasi data
  if (!title || !content) {
    return res.status(400).json({ message: 'Title and content are required' });
  }
  next();
};

module.exports = validateNews;
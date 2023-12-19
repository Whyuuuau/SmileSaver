// controllers/newsController.js
const News = require('../models/news.model');

const getAllNews = async (req, res) => {
  try {
    const newsArticles = await News.findAll(); // Find all entries in the Newstable
    res.json(newsArticles);
  } catch (error) {
    console.error(error);
    res.status(500).json({ message: "Error fetching news" });
  }
};

const createNews = (req, res) => {
  const { title, content } = req.body;
  if (!title || !content) {
    return res.status(400).json({ message: 'Title and content are required' });
  }

  // Simpan berita baru
  const News = new News(title, content);
  newNews.save().then((savedNews) => {
  res.status(201).json(savedNews);
    }).catch((error) => {
    console.error(error);
    res.status(500).json({ message: "Error creating news" });
    });
  res.status(201).json(News);
};

module.exports = { getAllNews, createNews };

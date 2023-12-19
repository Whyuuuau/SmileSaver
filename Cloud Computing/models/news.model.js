module.exports = (sequelize, Sequelize) => {
  const News = sequelize.define("news", {
    title: {
      type: Sequelize.STRING
    },
    content: {
      type: Sequelize.STRING
    }
  });

  return News;
};
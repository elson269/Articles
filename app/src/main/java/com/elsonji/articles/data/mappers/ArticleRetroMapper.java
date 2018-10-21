package com.elsonji.articles.data.mappers;

import com.elsonji.articles.data.models.RetroArticle;
import com.elsonji.articles.data.models.RetroArticleList;
import com.elsonji.articles.domain.models.Article;
import com.elsonji.articles.domain.models.ArticleList;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ArticleRetroMapper {

    public ArticleRetroMapper() {}

    public Article mapFrom(RetroArticle retroArticle) {
        Article article = null;
        if (retroArticle != null) {
            article = new Article(retroArticle.getTitle(), retroArticle.getUrlToImage(),
                    retroArticle.getDescription());
        }
        return article;
    }

    public ArticleList convertToArticleList(RetroArticleList retroArticleList) {
        ArticleList articleList = new ArticleList();
        List<Article> articles = new ArrayList<>();
        Article article;
        for (RetroArticle retroArticle : retroArticleList.getArticles()) {
            if (retroArticle != null) {
                article = mapFrom(retroArticle);
                articles.add(article);
                articleList.setArticles(articles);
            }
        }
        return articleList;
    }

}

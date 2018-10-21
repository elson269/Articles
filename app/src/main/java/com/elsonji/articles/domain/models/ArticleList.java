package com.elsonji.articles.domain.models;

import com.elsonji.articles.data.models.RetroArticle;

import java.util.List;

public class ArticleList {

    private String status;

    private String source;

    private String sortBy;

    private List<Article> articles = null;

//    public ArticleList(String status, String source, String sortBy, List<Article> articleList) {
//        this.status = status;
//        this.source = source;
//        this.sortBy = sortBy;
//        articles = articleList;
//    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

}

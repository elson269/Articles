package com.elsonji.articles.data.repositories;

import com.elsonji.articles.data.models.RetroArticle;
import com.elsonji.articles.data.models.RetroArticleList;
import com.elsonji.articles.domain.models.Article;

import java.util.List;

import io.reactivex.Observable;

public interface ArticleDataStore {
    Observable<RetroArticleList> getRetroArticles();
}

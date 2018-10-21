package com.elsonji.articles.domain.repositories;

import com.elsonji.articles.domain.models.Article;
import com.elsonji.articles.domain.models.ArticleList;

import java.util.List;

import io.reactivex.Observable;

public interface ArticleRepository {
    Observable<ArticleList> getArticles();
}

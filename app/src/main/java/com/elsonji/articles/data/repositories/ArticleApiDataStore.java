package com.elsonji.articles.data.repositories;

import com.elsonji.articles.data.models.RetroArticleList;
import com.elsonji.articles.data.networks.ServiceGenerator;

import io.reactivex.Observable;

public class ArticleApiDataStore implements ArticleDataStore {

    public ArticleApiDataStore() {
    }

    @Override
    public Observable<RetroArticleList> getRetroArticles() {
        return ServiceGenerator.getDataService().getArticles();
    }
}

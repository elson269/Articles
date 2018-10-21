package com.elsonji.articles.data.repositories;

import com.elsonji.articles.data.mappers.ArticleRetroMapper;
import com.elsonji.articles.data.models.RetroArticle;
import com.elsonji.articles.data.models.RetroArticleList;
import com.elsonji.articles.domain.models.Article;
import com.elsonji.articles.domain.models.ArticleList;
import com.elsonji.articles.domain.repositories.ArticleRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class ArticleRepositoryImpl implements ArticleRepository {

    private ArticleApiDataStore articleApiDataStore;
    private ArticleRetroMapper mapper;

    public ArticleRepositoryImpl(ArticleApiDataStore articleApiDataStore, ArticleRetroMapper mapper) {
        this.articleApiDataStore = articleApiDataStore;
        this.mapper = mapper;
    }

    @Override
    public Observable<ArticleList> getArticles() {
            return articleApiDataStore.getRetroArticles().map(new Function<RetroArticleList, ArticleList>() {
                @Override
                public ArticleList apply(RetroArticleList retroArticleList) throws Exception {
                    return mapper.convertToArticleList(retroArticleList);
                }
            });
    }
}

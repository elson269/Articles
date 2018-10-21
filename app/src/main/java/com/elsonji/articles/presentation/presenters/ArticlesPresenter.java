package com.elsonji.articles.presentation.presenters;

import com.elsonji.articles.domain.interactors.GetArticlesInteractor;
import com.elsonji.articles.domain.models.Article;
import com.elsonji.articles.domain.models.ArticleList;
import com.elsonji.articles.presentation.mappers.ArticleModelMapper;
import com.elsonji.articles.presentation.models.ArticleModel;
import com.elsonji.articles.presentation.models.ArticleModelList;
import com.elsonji.articles.presentation.views.ArticleListView;

import java.util.List;

import io.reactivex.observers.DisposableObserver;

public class ArticlesPresenter implements Presenter {

    private GetArticlesInteractor getArticlesInteractor;
    private ArticleModelMapper mapper;
    private ArticleListView articleListView;

    public ArticlesPresenter(GetArticlesInteractor getArticlesInteractor, ArticleModelMapper mapper) {
        this.getArticlesInteractor = getArticlesInteractor;
        this.mapper = mapper;
    }

    public void setArticleListView(ArticleListView listView) {
        this.articleListView = listView;
    }

    public void getArticleList() {
        getArticlesInteractor.execute(new DisposableObserver<ArticleList>() {
            @Override
            public void onNext(ArticleList articleList) {
                ArticleModelList articleModelList =
                        mapper.convertToArticleModelList(articleList);
                articleListView.renderArticleListView(articleModelList);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        }, null);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        getArticlesInteractor.dispose();
        articleListView = null;
    }
}

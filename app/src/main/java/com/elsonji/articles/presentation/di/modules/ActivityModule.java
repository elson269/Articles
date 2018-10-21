package com.elsonji.articles.presentation.di.modules;

import android.content.Context;

import com.elsonji.articles.data.mappers.ArticleRetroMapper;
import com.elsonji.articles.data.repositories.ArticleApiDataStore;
import com.elsonji.articles.data.repositories.ArticleRepositoryImpl;
import com.elsonji.articles.domain.interactors.GetArticlesInteractor;
import com.elsonji.articles.domain.models.Article;
import com.elsonji.articles.presentation.di.scopes.PerActivity;
import com.elsonji.articles.presentation.mappers.ArticleModelMapper;
import com.elsonji.articles.presentation.presenters.ArticlesPresenter;
import com.elsonji.articles.presentation.views.adapters.ArticleAdapter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    @PerActivity
    @Provides
    ArticlesPresenter provideArticlesPresenter(GetArticlesInteractor interactor, ArticleModelMapper mapper) {
        return new ArticlesPresenter(interactor, mapper);
    }

    @PerActivity
    @Provides
    GetArticlesInteractor provideArticleInteractor(ArticleRepositoryImpl articleRepository) {
        return new GetArticlesInteractor(articleRepository);
    }

    @PerActivity
    @Provides
    ArticleRepositoryImpl getArticleRepositoryImpl(ArticleApiDataStore store, ArticleRetroMapper mapper) {
        return new ArticleRepositoryImpl(store, mapper);
    }

    @PerActivity
    @Provides
    ArticleAdapter provideArticleAdapter(Context context) {
        return new ArticleAdapter(context);
    }

    @PerActivity
    @Provides
    ArrayList<Article> provideArraylist() {
        return new ArrayList<>();
    }
}

package com.elsonji.articles.presentation.di.modules;

import android.content.Context;

import com.elsonji.articles.data.mappers.ArticleRetroMapper;
import com.elsonji.articles.data.repositories.ArticleApiDataStore;
import com.elsonji.articles.presentation.mappers.ArticleModelMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    ArticleRetroMapper provideArticleRetroMapper() {
        return new ArticleRetroMapper();
    }

    @Provides
    @Singleton
    ArticleModelMapper provideArticleModelMapper() {
        return new ArticleModelMapper();
    }

    @Provides
    @Singleton
    ArticleApiDataStore provideArticleApiDataStore() {
        return new ArticleApiDataStore();
    }

}

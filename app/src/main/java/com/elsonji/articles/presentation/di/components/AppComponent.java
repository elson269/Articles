package com.elsonji.articles.presentation.di.components;

import android.content.Context;

import com.elsonji.articles.data.mappers.ArticleRetroMapper;
import com.elsonji.articles.data.repositories.ArticleApiDataStore;
import com.elsonji.articles.presentation.di.modules.AppModule;
import com.elsonji.articles.presentation.mappers.ArticleModelMapper;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    Context context();
    ArticleModelMapper articleModelMapper();
    ArticleRetroMapper articleRetroMapper();
    ArticleApiDataStore articleApiDataStore();
}

package com.elsonji.articles.presentation.di.components;

import com.elsonji.articles.presentation.di.modules.ActivityModule;
import com.elsonji.articles.presentation.di.scopes.PerActivity;
import com.elsonji.articles.presentation.views.activities.MainActivity;
import com.elsonji.articles.presentation.views.adapters.ArticleAdapter;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
    void inject(ArticleAdapter articleAdapter);
}

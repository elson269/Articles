package com.elsonji.articles.presentation.di;

import android.app.Application;

import com.elsonji.articles.presentation.di.components.ActivityComponent;
import com.elsonji.articles.presentation.di.components.AppComponent;
import com.elsonji.articles.presentation.di.components.DaggerActivityComponent;
import com.elsonji.articles.presentation.di.components.DaggerAppComponent;
import com.elsonji.articles.presentation.di.modules.ActivityModule;
import com.elsonji.articles.presentation.di.modules.AppModule;

public class ArticleApplication extends Application {
    private static AppComponent component;

    private static ActivityComponent activityComponent;

    public static ActivityComponent getComponent() {
        return activityComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        activityComponent = DaggerActivityComponent.builder()
                .appComponent(component)
                .build();
    }
}

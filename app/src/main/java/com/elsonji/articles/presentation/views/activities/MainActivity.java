package com.elsonji.articles.presentation.views.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.elsonji.articles.R;
import com.elsonji.articles.data.mappers.ArticleRetroMapper;
import com.elsonji.articles.data.repositories.ArticleApiDataStore;
import com.elsonji.articles.data.repositories.ArticleRepositoryImpl;
import com.elsonji.articles.domain.interactors.GetArticlesInteractor;
import com.elsonji.articles.domain.models.ArticleList;
import com.elsonji.articles.presentation.di.ArticleApplication;
import com.elsonji.articles.presentation.mappers.ArticleModelMapper;
import com.elsonji.articles.presentation.models.ArticleModelList;
import com.elsonji.articles.presentation.presenters.ArticlesPresenter;
import com.elsonji.articles.presentation.views.ArticleListView;
import com.elsonji.articles.presentation.views.adapters.ArticleAdapter;

import javax.inject.Inject;

import io.reactivex.Observable;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements ArticleListView {
    @BindView(R.id.article_list_recycler_view)
    RecyclerView mRecyclerView;

    @Inject
    ArticleAdapter articleAdapter;
    @Inject
    ArticleModelMapper articleModelMapper;
    @Inject
    ArticleRetroMapper articleRetroMapper;
    @Inject
    ArticleRepositoryImpl articleRepositoryImpl;
    @Inject
    GetArticlesInteractor getArticlesInteractor;
    @Inject
    ArticlesPresenter presenter;
    @Inject
    ArticleApiDataStore dataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ArticleApplication.getComponent().inject(this);

        //articleAdapter = new ArticleAdapter(this);
        mRecyclerView.setAdapter(articleAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //articleRetroMapper = new ArticleRetroMapper();
        //articleModelMapper = new ArticleModelMapper();
        //dataStore = new ArticleApiDataStore();
        //articleRepositoryImpl = new ArticleRepositoryImpl(dataStore, articleRetroMapper);
        //getArticlesInteractor = new GetArticlesInteractor(articleRepositoryImpl);
        //presenter = new ArticlesPresenter(getArticlesInteractor, articleModelMapper);
        presenter.setArticleListView(this);
        presenter.getArticleList();

        loadArticleList();
    }

    private void loadArticleList() {
        setItems(getArticlesInteractor.buildInteractorObservable(null));
    }

    void setItems(Observable<ArticleList> itemObservable) {
        itemObservable.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ArticleList>() {
                    @Override
                    public void accept(ArticleList articleList) throws Exception {
                        articleAdapter.setItems(articleList);
                    }
                });
    }

    @Override
    public void renderArticleListView(ArticleModelList articleModelList) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String errorMessage) {

    }

    @Override
    public Context getContext() {
        return this;
    }
}

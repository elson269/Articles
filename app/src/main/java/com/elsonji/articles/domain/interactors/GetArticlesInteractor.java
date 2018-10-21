package com.elsonji.articles.domain.interactors;

import com.elsonji.articles.domain.models.ArticleList;
import com.elsonji.articles.domain.repositories.ArticleRepository;

import io.reactivex.Observable;

public class GetArticlesInteractor extends Interactor<ArticleList, Void>{

    private ArticleRepository mArticleRepository;

    public GetArticlesInteractor(ArticleRepository articleRepository) {
        mArticleRepository = articleRepository;
    }

    @Override
    public Observable<ArticleList> buildInteractorObservable(Void aVoid) {
        return mArticleRepository.getArticles();
    }
}

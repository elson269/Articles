package com.elsonji.articles.data.networks;

import com.elsonji.articles.data.models.RetroArticle;
import com.elsonji.articles.data.models.RetroArticleList;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ArticleService {

    @GET("articles?source=the-verge&apiKey=2b62324bfb41493bb49e3bb19073d484")
    Observable<RetroArticleList> getArticles();
}

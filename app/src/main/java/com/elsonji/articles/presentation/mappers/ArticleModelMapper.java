package com.elsonji.articles.presentation.mappers;

import com.elsonji.articles.domain.models.Article;
import com.elsonji.articles.domain.models.ArticleList;
import com.elsonji.articles.presentation.models.ArticleModel;
import com.elsonji.articles.presentation.models.ArticleModelList;

import java.util.ArrayList;
import java.util.List;

public class ArticleModelMapper {

    public ArticleModelMapper() {
    }

    private ArticleModel mapFrom(Article article) {
        ArticleModel articleModel = null;
        if (article != null) {
            articleModel = new ArticleModel(article.getTitle(), article.getImageUrl(),
                    article.getDescription());
        }
        return articleModel;
    }

    public ArticleModelList convertToArticleModelList(ArticleList articleList) {
        ArticleModelList articleModelList = new ArticleModelList();
        List<ArticleModel> articleModels = new ArrayList<>();
        ArticleModel articleModel;
        for (Article article : articleList.getArticles()) {
            if (article != null) {
                articleModel = mapFrom(article);
                articleModels.add(articleModel);
                articleModelList.setArticles(articleModels);
            }
        }
        return articleModelList;
    }
}

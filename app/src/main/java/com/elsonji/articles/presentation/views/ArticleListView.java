package com.elsonji.articles.presentation.views;

import com.elsonji.articles.presentation.models.ArticleModel;
import com.elsonji.articles.presentation.models.ArticleModelList;

import java.util.List;

public interface ArticleListView extends LoadDataView {
    void renderArticleListView(ArticleModelList articleModelList);
}

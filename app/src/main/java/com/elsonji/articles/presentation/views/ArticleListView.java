package com.elsonji.articles.presentation.views;

import com.elsonji.articles.presentation.models.ArticleModelList;

public interface ArticleListView extends LoadDataView {
    void renderArticleListView(ArticleModelList articleModelList);
}

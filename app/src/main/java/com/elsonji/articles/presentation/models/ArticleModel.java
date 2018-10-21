package com.elsonji.articles.presentation.models;

public class ArticleModel {
    private String mTitle;

    private String mImageUrl;

    private String mDescription;

    public ArticleModel(String title, String imageUrl, String description) {
        mTitle = title;
        mImageUrl = imageUrl;
        mDescription = description;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    public String getImageUrl() {
        return mImageUrl;
    }
}

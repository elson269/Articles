package com.elsonji.articles.data.networks;

public class ServiceGenerator {
    private static ArticleService articleService;
    public static ArticleService getDataService() {
        if (articleService == null) {
            articleService = RetrofitClientInstance.getRetrofitInstance().create(ArticleService.class);
        }
        return articleService;
    }
}

package my.news.core.service;

import my.news.core.model.NewsModel;

import java.util.List;

public interface NewsService {
    List<NewsModel> getNews();

    NewsModel getNewsForCode(String code);
}

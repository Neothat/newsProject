package my.news.facades.newsfacade;

import my.news.facades.data.NewsData;

import java.util.List;

public interface NewsFasade {
    NewsData getOneNews(String code);

    List<NewsData> getAllNews();
}

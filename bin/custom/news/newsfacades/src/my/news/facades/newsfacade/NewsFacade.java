package my.news.facades.newsfacade;

import my.news.facades.data.NewsData;

import java.util.List;

public interface NewsFacade {
    NewsData getOneNews(String code);

    List<NewsData> getAllNews();
}

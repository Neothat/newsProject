package my.news.facades.newsfacade.impl;

import my.news.core.model.NewsModel;
import my.news.core.service.NewsService;
import my.news.facades.data.NewsData;
import my.news.facades.newsfacade.NewsFacade;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class DefaultNewsFacade implements NewsFacade {

    private NewsService newsService;
    private Converter<NewsModel, NewsData> newsConverter;

    @Override
    public NewsData getOneNews(String code) throws IllegalArgumentException {
        if (code == null) {
            throw new IllegalArgumentException("News name cannot be null");
        }

        final NewsModel newsModel = newsService.getNewsForCode(code);

        NewsData newsData = newsConverter.convert(newsModel);
        return newsData;

    }

    @Override
    public List<NewsData> getAllNews() {
        final List<NewsModel> newsModels = newsService.getNews();
        final List<NewsData> newsFasadeData = new ArrayList<>();
        for (final NewsModel nm : newsModels) {
            newsFasadeData.add(newsConverter.convert(nm));
        }
        return newsFasadeData;
    }

    public void setNewsService(NewsService newsService) {
        this.newsService = newsService;
    }

    public void setConverter(Converter newsConverter) {
        this.newsConverter = (Converter<NewsModel, NewsData>) newsConverter;
    }

}

package my.news.core.daos;

import my.news.core.model.NewsModel;

import java.util.List;

public interface NewsDao {
    List<NewsModel> findNews();

    List<NewsModel> findNewsByCode(String code);
}

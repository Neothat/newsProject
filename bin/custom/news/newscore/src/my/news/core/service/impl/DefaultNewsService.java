package my.news.core.service.impl;

import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import my.news.core.daos.NewsDao;
import my.news.core.model.NewsModel;
import my.news.core.service.NewsService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultNewsService implements NewsService {
    private NewsDao newsDao;

    @Override
    public List<NewsModel> getNews() {
        return newsDao.findNews();
    }

    @Override
    public NewsModel getNewsForCode(final String code) throws AmbiguousIdentifierException, UnknownIdentifierException {
        final List<NewsModel> result = newsDao.findNewsByCode(code);
        if (result.isEmpty()) {
            throw new UnknownIdentifierException("News with code '" + code + "' not found!");
        } else if (result.size() > 1) {
            throw new AmbiguousIdentifierException("News code '" + code + "' is not unique, " + result.size() + " news found!");
        }
        return result.get(0);
    }

    @Required
    public void setNewsDao(final NewsDao newsDao) {
        this.newsDao = newsDao;
    }
}

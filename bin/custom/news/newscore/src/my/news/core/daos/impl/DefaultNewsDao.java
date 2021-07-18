package my.news.core.daos.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import my.news.core.daos.NewsDao;
import my.news.core.model.NewsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "newsDao")
public class DefaultNewsDao implements NewsDao {
    @Autowired
    private FlexibleSearchService flexibleSearchService;

    @Override
    public List<NewsModel> findNews() {
        final String queryString =
                "SELECT {p:" + NewsModel.PK + "} "
                        + "FROM {" + NewsModel._TYPECODE + " AS p} ";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        return flexibleSearchService.searchUnique(query);
    }

    @Override
    public List<NewsModel> findNewsByCode(final String code) {
        final String queryString = //
                "SELECT {p:" + NewsModel.PK + "}" //
                        + "FROM {" + NewsModel._TYPECODE + " AS p} "//
                        + "WHERE " + "{p:" + NewsModel.CODE + "}=?code ";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        query.addQueryParameter("code", code);
        return flexibleSearchService.searchUnique(query);
    }
}

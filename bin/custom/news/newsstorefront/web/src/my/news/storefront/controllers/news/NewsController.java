package my.news.storefront.controllers.news;

import de.hybris.platform.catalog.CatalogVersionService;
import my.news.facades.data.NewsData;
import my.news.facades.newsfacade.NewsFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Controller
public class NewsController {
    private static final String CATALOG_ID = "newsContentCatalog";
    private static final String CATALOG_VERSION_NAME = "Online";
    private CatalogVersionService catalogVersionService;

    private NewsFacade newsFacade;

    @RequestMapping(value = "/allNews")
    public String showAllNews(final Model model) {
        final List<NewsData> news = newsFacade.getAllNews();
        model.addAttribute("news", news);
        return "NewsList";
    }

    @RequestMapping(value = "/allNews/{newsCode}")
    public String showNewsDetails(@PathVariable final String newsCode, final Model model) throws UnsupportedEncodingException {
        catalogVersionService.setSessionCatalogVersion(CATALOG_ID, CATALOG_VERSION_NAME);

        final String decodedNewsCode = URLDecoder.decode(newsCode, "UTF-8");
        final NewsData news = newsFacade.getOneNews(decodedNewsCode);
        model.addAttribute("news", news);
        return "NewsDetails";
    }

    @Autowired
    public void setCatalogVersionService(final CatalogVersionService catalogVersionServiceService)
    {
        this.catalogVersionService = catalogVersionServiceService;
    }

    @Autowired
    public void setFacade(final NewsFacade facade) {
        this.newsFacade = facade;
    }
}

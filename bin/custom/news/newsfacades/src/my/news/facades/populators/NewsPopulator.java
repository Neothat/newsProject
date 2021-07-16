package my.news.facades.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import my.news.core.model.NewsModel;
import my.news.core.service.NewsService;
import my.news.facades.data.NewsData;

import java.util.List;

public class NewsPopulator implements Populator<NewsModel, NewsData> {

    @Override
    public void populate(NewsModel source, NewsData target) throws ConversionException {
        target.setCode(source.getCode());
        target.setTitle(source.getTitle());
        //target.setImage(source.getImage());
        target.setText(source.getText());
        target.setStartDate(source.getStartDate());
        target.setEndDate(source.getEndDate());
        //target.setProduct(source.getProduct());
    }
}

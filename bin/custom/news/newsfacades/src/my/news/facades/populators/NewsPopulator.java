package my.news.facades.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.media.MediaContainerModel;
import de.hybris.platform.jalo.media.MediaContainer;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import de.hybris.platform.servicelayer.media.MediaService;
import my.news.core.model.NewsModel;
import my.news.core.service.NewsService;
import my.news.facades.data.NewsData;

import java.util.List;

public class NewsPopulator implements Populator<NewsModel, NewsData> {

    private MediaService mediaService;

    @Override
    public void populate(NewsModel source, NewsData target) throws ConversionException {
        target.setCode(source.getCode());
        target.setTitle(source.getTitle());
        target.setImage(getImage(source));
        target.setText(source.getText());
        target.setStartDate(source.getStartDate());
        target.setEndDate(source.getEndDate());
        //target.setProduct(source.getProduct());
    }

    private String getImage(NewsModel newsModel) {
        return mediaService.getUrlForMedia(newsModel.getImage());
    }

    public void setMediaService(MediaService mediaService) {
        this.mediaService = mediaService;
    }
}

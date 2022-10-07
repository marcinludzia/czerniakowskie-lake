package com.candf;

import com.candf.client.HttpClientWrapper;
import com.candf.client.IHttpClient;
import com.candf.client.IWeatherInformationClient;
import com.candf.client.imgw.ImgwWeatherInformationApiClient;
import com.candf.core.service.ClothingRecommendationService;
import com.candf.core.service.IClothingRecommendation;
import io.javalin.Javalin;

public class Configuration {
    private final IHttpClient apiClient = new HttpClientWrapper();
    private final IWeatherInformationClient weatherClient = new ImgwWeatherInformationApiClient(apiClient);
    private final IClothingRecommendation clothingRecommendation = new ClothingRecommendationService();
    private final Javalin application = Javalin.create();



    public IWeatherInformationClient getWeatherClient() {
        return weatherClient;
    }
    public IClothingRecommendation getClothingRecommendation() {
        return clothingRecommendation;
    }
    public Javalin getApplication() {
        return application;
    }
}

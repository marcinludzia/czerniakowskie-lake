package com.candf;

import com.candf.client.IWeatherInformationClient;
import com.candf.client.imgw.ImgwWeatherInformationApiClient;
import com.candf.service.ClothingRecommendationService;
import com.candf.service.IClothingRecommendation;
import io.javalin.Javalin;

import java.net.http.HttpClient;
import java.time.Duration;

public class Configuration {
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(30))
            .followRedirects(HttpClient.Redirect.NORMAL)
            .build();
    private final IWeatherInformationClient weatherClient = new ImgwWeatherInformationApiClient(httpClient);
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

package com.candf.controller;

import com.candf.client.IWeatherInformationClient;
import com.candf.service.IClothingRecommendation;
import io.javalin.http.Context;

public class RecommendationController {

    IClothingRecommendation clothingRecommendation;
    IWeatherInformationClient weatherInformationClient;

    public RecommendationController(IClothingRecommendation clothingRecommendation,
                                    IWeatherInformationClient imgwWeatherInformationClient) {
        this.clothingRecommendation = clothingRecommendation;
        this.weatherInformationClient = imgwWeatherInformationClient;
    }

    public void getClothingRecommendation(Context ctx) {
        String location = ctx.pathParam("location");
        var weatherInformation = weatherInformationClient.getWeatherInformation(location);
        if (weatherInformation.isEmpty()) {
            ctx.status(400).result("Nie można było ustalić rekomendacji");
        }
        var cloths = clothingRecommendation.recommendOnClothing(weatherInformation.get());
        var sunGlasses = clothingRecommendation.recommendOnSunGlasses(weatherInformation.get());

        ctx.status(200).result(cloths + "\n" + sunGlasses);
    }
}

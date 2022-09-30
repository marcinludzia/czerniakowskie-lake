package com.candf.controller;

import com.candf.client.IWeatherInformationClient;
import com.candf.service.IClothingRecommendation;

public class RecommendationController {

    private final IClothingRecommendation clothingRecommendation;
    private final IWeatherInformationClient weatherInformationClient;
    private final String EMPTY_STRING = "";

    public RecommendationController(IClothingRecommendation clothingRecommendation,
                                    IWeatherInformationClient imgwWeatherInformationClient) {
        this.clothingRecommendation = clothingRecommendation;
        this.weatherInformationClient = imgwWeatherInformationClient;
    }

    public String getClothingRecommendation(String location) {
        var weatherInformation = weatherInformationClient.getWeatherInformation(location);
        if (weatherInformation.isEmpty()) {
            return EMPTY_STRING;
        }
        var cloths = clothingRecommendation.recommendOnClothing(weatherInformation.get());
        var sunGlasses = clothingRecommendation.recommendOnSunGlasses(weatherInformation.get());

        return cloths + "\n" + sunGlasses;
    }
}

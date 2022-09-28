package com.candf.service;

import com.candf.model.WeatherInformation;

public interface IClothingRecommendation {
    String recommendOnClothing(WeatherInformation information);
    String recommendOnSunGlasses(WeatherInformation information);
}

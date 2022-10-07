package com.candf.core.service;

import com.candf.core.model.WeatherInformation;

public interface IClothingRecommendation {
    String recommendOnClothing(WeatherInformation information);
    String recommendOnSunGlasses(WeatherInformation information);
}

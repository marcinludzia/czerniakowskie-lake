package com.candf.service;

import com.candf.model.WeatherInformation;

import java.io.UnsupportedEncodingException;

public interface IClothingRecommendation {
    String recommendOnClothing(WeatherInformation information);
    String recommendOnSunGlasses(WeatherInformation information);
}

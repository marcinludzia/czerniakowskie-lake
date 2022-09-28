package com.candf.client;

import com.candf.model.WeatherInformation;
import java.util.Optional;

public interface IWeatherInformationClient {
    Optional<WeatherInformation> getWeatherInformation(String localization);
}

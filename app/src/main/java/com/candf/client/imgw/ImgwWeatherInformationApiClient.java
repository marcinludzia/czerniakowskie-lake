package com.candf.client.imgw;

import com.candf.client.IHttpClient;
import com.candf.client.IWeatherInformationClient;
import com.candf.core.model.WeatherInformation;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.Optional;

public class ImgwWeatherInformationApiClient implements IWeatherInformationClient {

    private final IHttpClient apiClient;
    private final String BASE_URL = "https://danepubliczne.imgw.pl/api/data/synop/station/";
    private final String EMPTY_STRING = "";

    public ImgwWeatherInformationApiClient(IHttpClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public Optional<WeatherInformation> getWeatherInformation(String localization) {
        var targetUrl = createTargetUrl(localization);
        var responseBody = getWeatherInformationResponse(targetUrl);
        if (responseBody.equals(EMPTY_STRING)) {
            return Optional.empty();
        }
        ImgwWeatherInformation imgwWeatherInformation = deserializeResponseBody(responseBody);

        return imgwWeatherInformation != null
                ? Optional.of(new WeatherInformation(Double.parseDouble(imgwWeatherInformation.getTemperature()),
                                                     Double.parseDouble(imgwWeatherInformation.getHumidity())))
                : Optional.empty();
    }

    private ImgwWeatherInformation deserializeResponseBody(String responseBody) {
        Gson gson = new Gson();
        ImgwWeatherInformation imgwWeatherInformation;
        try {
            imgwWeatherInformation = gson.fromJson(responseBody, ImgwWeatherInformation.class);
        }
        catch (JsonSyntaxException exception) {
            System.out.println(exception.getMessage());
            return null;
        }

        return imgwWeatherInformation;
    }

    private String getWeatherInformationResponse(String targetUrl) {
        return apiClient.getResponse(targetUrl);
    }

    private String createTargetUrl(String localization) {
        return BASE_URL + localization;
    }

}

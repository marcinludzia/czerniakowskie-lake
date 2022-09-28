package com.candf.client.imgw;

import com.candf.client.IWeatherInformationClient;
import com.candf.model.WeatherInformation;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;

public class ImgwWeatherInformationApiClient implements IWeatherInformationClient {

    private final HttpClient client;

    private final String BASE_URL = "https://danepubliczne.imgw.pl/api/data/synop/station/";
    private final int OK = 200;
    private final String EMPTY_STRING = "";

    public ImgwWeatherInformationApiClient(HttpClient client) {
        this.client = client;
    }

    @Override
    public Optional<WeatherInformation> getWeatherInformation(String localization) {
        var targetUrl = createTargetUrl(localization);
        var responseBody = getWeatherInformationResponse(targetUrl);
        if (responseBody.equals(EMPTY_STRING)) {
            return Optional.empty();
        }
        ImgwWeatherInformation imgwWeatherInformation = deserializeResponseBody(responseBody);

        return Optional.of(new WeatherInformation(Double.parseDouble(imgwWeatherInformation.getTemperature()),
                                                  Double.parseDouble(imgwWeatherInformation.getHumidity())));
    }

    private ImgwWeatherInformation deserializeResponseBody(String responseBody) {
        Gson gson = new Gson();
        ImgwWeatherInformation imgwWeatherInformation;
        try {
            imgwWeatherInformation = gson.fromJson(responseBody, ImgwWeatherInformation.class);
        }
        catch (JsonSyntaxException exception) {
            System.out.println(exception.getMessage());
            return new ImgwWeatherInformation("n/a", "n/a", "n/a", "n/a", "n/a", "n/a",
                    "n/a", "n/a", "n/a", "n/a");
        }

        return imgwWeatherInformation;
    }

    private String getWeatherInformationResponse(String targetUrl) {
        HttpResponse<String> response;
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .timeout(Duration.ofSeconds(30))
                .uri(URI.create(targetUrl))
                .GET()
                .build();

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
            return EMPTY_STRING;
        }

        return response.statusCode() == OK ? response.body() : EMPTY_STRING;
    }

    private String createTargetUrl(String localization) {
        return BASE_URL + localization;
    }
}

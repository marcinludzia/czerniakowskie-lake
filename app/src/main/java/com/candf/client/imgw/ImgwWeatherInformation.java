package com.candf.client.imgw;

import com.google.gson.annotations.SerializedName;

public class ImgwWeatherInformation {
    @SerializedName("id_stacji") private String stationId;
    @SerializedName("stacja") private String weatherStation;
    @SerializedName("data_pomiaru") private String date;
    @SerializedName("godzina_pomiaru") private String hour;
    @SerializedName("temperatura") private String temperature;
    @SerializedName("predkosc_wiatru") private String windSpeed;
    @SerializedName("kierunek_wiatru") private String windDirection;
    @SerializedName("wilgotnosc_wzgledna") private String humidity;
    @SerializedName("suma_opadu") private String sumOfFall;
    @SerializedName("cisnienie") private String atmosphericPressure;

    public ImgwWeatherInformation(String stationId,
                                  String weatherStation,
                                  String date,
                                  String hour,
                                  String temperature,
                                  String windSpeed,
                                  String windDirection,
                                  String humidity,
                                  String sumOfFall,
                                  String atmosphericPressure) {
        this.stationId = stationId;
        this.weatherStation = weatherStation;
        this.date = date;
        this.hour = hour;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.humidity = humidity;
        this.sumOfFall = sumOfFall;
        this.atmosphericPressure = atmosphericPressure;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getWeatherStation() {
        return weatherStation;
    }

    public void setWeatherStation(String weatherStation) {
        this.weatherStation = weatherStation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getSumOfFall() {
        return sumOfFall;
    }

    public void setSumOfFall(String sumOfFall) {
        this.sumOfFall = sumOfFall;
    }

    public String getAtmosphericPressure() {
        return atmosphericPressure;
    }

    public void setAtmosphericPressure(String atmosphericPressure) {
        this.atmosphericPressure = atmosphericPressure;
    }
}

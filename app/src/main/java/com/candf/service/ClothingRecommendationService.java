package com.candf.service;

import com.candf.model.WeatherInformation;

import javax.lang.model.type.ExecutableType;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class ClothingRecommendationService implements IClothingRecommendation {

    @Override
    public String recommendOnClothing(WeatherInformation information) {
        if (information.temperature() < 0.0) {
            return "Ubierz ciepłą kurtkę, czapkę i rękawiczki.";
        }
        else if (information.temperature() >= 0.0 && information.temperature() < 10.0) {
            return new String("Ubierz kurtkę wiosenną.".getBytes(StandardCharsets.UTF_8));
        }
        else if (information.temperature() >= 10.0 && information.temperature() < 22.0) {
            return new String("Ubierz bluzę.".getBytes(StandardCharsets.UTF_8));
        }
        else {
            return "Ubierz krótkie spodenki i koszulkę. Jest gorąco!";
        }
    }

    @Override
    public String recommendOnSunGlasses(WeatherInformation information)  {
        if (information.temperature() > 15.0 && information.humidity() < 50.0) {
            return "Zabierz ze sobą okulary przeciwsloneczne!";
        }
        else {
            try {
                return new String("Nie musisz zabierać ze sobą okularów przeciwsłonecznych.".getBytes(), "utf-8");
            }
            catch(Exception e) {
                System.out.println("WYJĄTEK!!!!");
                return "Nie musisz zabierać ze sobą okularów przeciwsłonecznych.";
            }
        }
    }
}

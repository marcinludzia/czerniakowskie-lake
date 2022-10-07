package com.candf.core.service;

import com.candf.core.model.WeatherInformation;

import java.nio.charset.StandardCharsets;

public class ClothingRecommendationService implements IClothingRecommendation {

    @Override
    public String recommendOnClothing(WeatherInformation information) {
        if (information.temperature() < 0.0) {
            return "Ubierz ciepłą kurtkę, czapkę i rękawiczki. Obecnie jest " + information.temperature() + " st.C." ;
        }
        else if (information.temperature() >= 0.0 && information.temperature() < 10.0) {
            return "Ubierz kurtkę wiosenną. Obecnie jest " + information.temperature() + " st.C.";
        }
        else if (information.temperature() >= 10.0 && information.temperature() < 22.0) {
            return "Ubierz bluzę. Obecnie jest " + information.temperature() + " st.C.";
        }
        else {
            return "Ubierz krótkie spodenki i koszulkę. Jest gorąco! Obecnie jest " + information.temperature() + " st.C.";
        }
    }

    @Override
    public String recommendOnSunGlasses(WeatherInformation information)  {
        if (information.temperature() > 15.0 && information.humidity() < 50.0) {
            return "Zabierz ze sobą okulary przeciwsloneczne!";
        }
        else {
            return "Nie musisz zabierać ze sobą okularów przeciwsłonecznych.";
        }
    }
}

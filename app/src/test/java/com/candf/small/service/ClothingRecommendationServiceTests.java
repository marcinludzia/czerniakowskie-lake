package com.candf.small.service;

import com.candf.core.model.WeatherInformation;
import com.candf.core.service.ClothingRecommendationService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ClothingRecommendationServiceTests {

    private ClothingRecommendationService service;

    @BeforeClass
    public void setUp() {
        service = new ClothingRecommendationService();
    }

    @DataProvider(name = "weather_information")
    public Object[][] serveWeatherInformation() {
        return new Object[][] {
                {0.0, 0.0, "Ubierz kurtkę wiosenną.", "Nie musisz zabierać ze sobą okularów przeciwsłonecznych."},
                {-10.0, 20.0, "Ubierz ciepłą kurtkę, czapkę i rękawiczki.", "Nie musisz zabierać ze sobą okularów przeciwsłonecznych."},
                {12.1, 40.5, "Ubierz bluzę.", "Nie musisz zabierać ze sobą okularów przeciwsłonecznych."},
                {17.0, 55.2, "Ubierz bluzę.", "Nie musisz zabierać ze sobą okularów przeciwsłonecznych."},
                {33.9, 24.9, "Ubierz krótkie spodenki i koszulkę. Jest gorąco!", "Zabierz ze sobą okulary przeciwsloneczne!"},
                {18.3, 98.8, "Ubierz bluzę.", "Nie musisz zabierać ze sobą okularów przeciwsłonecznych."}
        };
    }

    @Test(description = "Should provide proper recommendation for clothing options",
          dataProvider = "weather_information")
    public void shouldProvideProperRecommendationForClothing(double temperature, double humidity, String clothingRecommendation, String sunGlassesRecommendation) {
        var weatherInformation = new WeatherInformation(temperature, humidity);

        String recommendation = service.recommendOnClothing(weatherInformation);

        Assert.assertEquals(recommendation, clothingRecommendation);

    }

    @Test(description = "Should provide proper recommendation for sunglasses",
          dataProvider = "weather_information")
    public void shouldProvideProperRecommendationOnSunGlasses(double temperature, double humidity, String clothingRecommendation, String sunglassesRecommendation) {
        var weatherInformation = new WeatherInformation(temperature, humidity);

        var recommendation = service.recommendOnSunGlasses(weatherInformation);

        Assert.assertEquals(recommendation, sunglassesRecommendation);
    }
}

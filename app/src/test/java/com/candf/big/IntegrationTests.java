package com.candf.big;

import com.candf.client.imgw.ImgwWeatherInformationApiClient;
import com.candf.common.MocksFactory;
import com.candf.controller.RecommendationController;
import com.candf.service.ClothingRecommendationService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IntegrationTests {

    @Test(description = "Integration test for the Czerniakowskie Lake application")
    public void integrationFlow() {
        var httpClientMock = MocksFactory.getMockedHttpApiClient();
        var apiClient = new ImgwWeatherInformationApiClient(httpClientMock);
        var service = new ClothingRecommendationService();
        var controller = new RecommendationController(service, apiClient);

        var result = controller.getClothingRecommendation("warszawa");

        Assert.assertTrue(result.contains("Ubierz bluzę."));
    }
}

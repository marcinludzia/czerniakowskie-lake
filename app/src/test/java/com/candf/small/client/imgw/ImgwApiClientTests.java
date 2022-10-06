package com.candf.small.client.imgw;

import com.candf.client.HttpClientWrapper;
import com.candf.client.IHttpClient;
import com.candf.client.imgw.ImgwWeatherInformationApiClient;
import com.candf.common.MocksFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

public class ImgwApiClientTests {

    @Test(description = "Should properly get and parse responses")
    public void testHttpClientTTest() {

        IHttpClient apiClientMock = MocksFactory.getMockedHttpApiClient();
        ImgwWeatherInformationApiClient weatherInforClient = new ImgwWeatherInformationApiClient(apiClientMock);

        var info = weatherInforClient.getWeatherInformation("warszawa");

        Assert.assertEquals(info.get().temperature(), 10.8);
        Assert.assertEquals(info.get().humidity(), 77.6);
    }
}

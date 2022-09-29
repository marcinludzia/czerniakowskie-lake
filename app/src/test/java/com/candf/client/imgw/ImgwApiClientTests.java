package com.candf.client.imgw;

import com.candf.client.HttpClientMock;
import com.candf.client.IHttpClient;
import org.testng.annotations.Test;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImgwApiClientTests {

    @Test
    public void testHttpClientTTest() throws IOException, InterruptedException {
        IHttpClient apiClientMock = new MockedHttpApiClient();
        ImgwWeatherInformationApiClient weatherInforClient = new ImgwWeatherInformationApiClient(apiClientMock);
        var info = weatherInforClient.getWeatherInformation("warszawa");
        System.out.println("Temperatura: " + info.get().temperature());
        System.out.println("Humidity: " + info.get().humidity());
    }

    class MockedHttpApiClient implements IHttpClient {

        @Override
        public String getResponse(String url) {
            return "{\"id_stacji\":\"12500\",\"stacja\":\"Jelenia G\\u00f3ra\",\"data_pomiaru\":\"2022-09-29\",\"godzina_pomiaru\":\"16\",\"temperatura\":\"10.8\",\"predkosc_wiatru\":\"1\",\"kierunek_wiatru\":\"270\",\"wilgotnosc_wzgledna\":\"77.6\",\"suma_opadu\":\"0.2\",\"cisnienie\":\"1005.5\"}";
        }
    }
}

package com.candf.common;

import com.candf.client.IHttpClient;

public class MockedHttpApiClient implements IHttpClient {
    @Override
    public String getResponse(String url) {
        return """
                {
                    "id_stacji":"12500",
                    "stacja":"Jelenia G\\u00f3ra",
                    "data_pomiaru":"2022-09-29",
                    "godzina_pomiaru":"16"
                    ,"temperatura":"10.8",
                    "predkosc_wiatru":"1",
                    "kierunek_wiatru":"270",
                    "wilgotnosc_wzgledna":"77.6",
                    "suma_opadu":"0.2",
                    "cisnienie":"1005.5"
                }
                """;
    }
}

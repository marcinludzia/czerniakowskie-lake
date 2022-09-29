package com.candf.common;

import com.candf.client.IHttpClient;

public class MocksFactory {
    public static IHttpClient getMockedHttpApiClient() {
        return new MockedHttpApiClient();
    }
}

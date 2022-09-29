package com.candf.client;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.net.Authenticator;
import java.net.CookieHandler;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class HttpClientMock {
//
//    @Override
//    public Optional<CookieHandler> cookieHandler() {
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<Duration> connectTimeout() {
//        return Optional.empty();
//    }
//
//    @Override
//    public Redirect followRedirects() {
//        return null;
//    }
//
//    @Override
//    public Optional<ProxySelector> proxy() {
//        return Optional.empty();
//    }
//
//    @Override
//    public SSLContext sslContext() {
//        return null;
//    }
//
//    @Override
//    public SSLParameters sslParameters() {
//        return null;
//    }
//
//    @Override
//    public Optional<Authenticator> authenticator() {
//        return Optional.empty();
//    }
//
//    @Override
//    public Version version() {
//        return null;
//    }
//
//    @Override
//    public Optional<Executor> executor() {
//        return Optional.empty();
//    }
//
//    @Override
//    public <T> HttpResponse<T> send(HttpRequest request, HttpResponse.BodyHandler<T> responseBodyHandler) throws IOException, InterruptedException {
//        return new HttpResponse<>() {
//            @Override
//            public int statusCode() {
//                return 200;
//            }
//
//            @Override
//            public HttpRequest request() {
//                return null;
//            }
//
//            @Override
//            public Optional<HttpResponse<T>> previousResponse() {
//                return Optional.empty();
//            }
//
//            @Override
//            public HttpHeaders headers() {
//                return null;
//            }
//
//            @Override
//            public T body() {
//                if (T i String) {
//                    return "{\"id_stacji\":\"12500\",\"stacja\":\"Jelenia G\\u00f3ra\",\"data_pomiaru\":\"2022-09-29\",\"godzina_pomiaru\":\"16\",\"temperatura\":\"10.8\",\"predkosc_wiatru\":\"1\",\"kierunek_wiatru\":\"270\",\"wilgotnosc_wzgledna\":\"77.6\",\"suma_opadu\":\"0.2\",\"cisnienie\":\"1005.5\"}";
//                }
//                else {
//                    return T;
//                }
//            }
//
//            @Override
//            public Optional<SSLSession> sslSession() {
//                return Optional.empty();
//            }
//
//            @Override
//            public URI uri() {
//                return null;
//            }
//
//            @Override
//            public Version version() {
//                return null;
//            }
//        };
//    }
//
//    @Override
//    public <T> CompletableFuture<HttpResponse<T>> sendAsync(HttpRequest request, HttpResponse.BodyHandler<T> responseBodyHandler) {
//        return null;
//    }
//
//    @Override
//    public <T> CompletableFuture<HttpResponse<T>> sendAsync(HttpRequest request, HttpResponse.BodyHandler<T> responseBodyHandler, HttpResponse.PushPromiseHandler<T> pushPromiseHandler) {
//        return null;
//    }

}

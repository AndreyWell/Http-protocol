package ru.netology;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static final String REMOTE_SERVICE_URL
            = "https://raw.githubusercontent.com/netology-code/jd-homeworks/master/http/task1/cats";

    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder
                .create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setSocketTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        HttpGet request = new HttpGet(REMOTE_SERVICE_URL);

        CloseableHttpResponse response = httpClient.execute(request);

        String body = new String(response.getEntity().getContent().readAllBytes(),
                StandardCharsets.UTF_8);

        List<Cat> cats = mapper.readValue(
                body,
                new TypeReference<>() {});

        List<Cat> collect = cats.stream()
                .filter(cat -> cat.getUpVotes() != null)
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }
}
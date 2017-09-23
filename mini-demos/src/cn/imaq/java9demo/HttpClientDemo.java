package cn.imaq.java9demo;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpClientDemo {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newHttpClient();
        // HTTP/1.1 GET
        try {
            HttpRequest request = HttpRequest.newBuilder().GET()
                    .uri(new URI("https://http2.akamai.com/"))
                    .build();
            CompletableFuture<HttpResponse<String>> future = httpClient.sendAsync(request, HttpResponse.BodyHandler.asString());
            System.out.println(getResult(future.get().body()));
        } catch (URISyntaxException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // HTTP/2 GET (貌似没有效果，原因未知)
        try {
            HttpRequest request = HttpRequest.newBuilder().GET()
                    .version(HttpClient.Version.HTTP_2)
                    .uri(new URI("https://http2.akamai.com/"))
                    .build();
            CompletableFuture<HttpResponse<String>> future = httpClient.sendAsync(request, HttpResponse.BodyHandler.asString());
            System.out.println(getResult(future.get().body()));
        } catch (URISyntaxException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static Pattern pattern = Pattern.compile("^.*<h2 class=\"highlight\">\\s*([^<]+)<.*$", Pattern.DOTALL);

    private static String getResult(String html) {
        Matcher matcher = pattern.matcher(html);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return "";
    }
}

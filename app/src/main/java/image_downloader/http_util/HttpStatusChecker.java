package image_downloader.http_util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    public String getStatusImage(int code) {
        StringBuilder response = new StringBuilder();

        try {
            URI uri = new URI("https://http.cat");

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(uri + "/" + code + ".jpg"))
                    .GET()
                    .build();

            HttpResponse<String> send = CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            int responseCode = send.statusCode();

            if(responseCode != 200){
                System.err.println("There is not image for HTTP status " + code);
            } else  {
                response.append(send.uri());
            }

        } catch (URISyntaxException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }
}

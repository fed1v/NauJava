import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Task4 {
    public static void main(String[] args) {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create("https://httpbin.org/ip"))
                .build();

        try {
            String response = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .get(5, TimeUnit.SECONDS);

            IP ip = new ObjectMapper().readValue(response, IP.class);
            System.out.println(ip.origin);

        } catch (ExecutionException | InterruptedException | TimeoutException | IOException e) {
            e.printStackTrace();
        }
    }
}

class IP {
    public String origin;
}

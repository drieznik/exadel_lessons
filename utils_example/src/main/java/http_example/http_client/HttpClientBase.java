package http_example.http_client;

import java.io.IOException;

public interface HttpClientBase {
    String sendGetRequest(String url, String searchString) throws IOException;

    String sendPostRequest(String url, String body, String contentType) throws IOException;
}

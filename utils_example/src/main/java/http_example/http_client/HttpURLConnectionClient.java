package http_example.http_client;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.io.IOException;
import java.util.Properties;


public class HttpURLConnectionClient implements HttpClientBase{

   enum RequestMethods {GET, POST, PUT, PATCH, DELETE}

    @Override
    public String sendGetRequest(String url, String searchString) throws IOException {
        URL myUrl = new URL(url);
        HttpURLConnection con = (HttpURLConnection) myUrl.openConnection();

        con.setRequestMethod(RequestMethods.GET.name());
        con.setRequestProperty("q", searchString);

        System.out.println("Response is: " + con.getResponseCode() + ", " + con.getResponseMessage());

        return null;
    }


    @Override
    public String sendPostRequest(String url, String body, String contentType) throws IOException {
       URL myPostUrl = new URL("http://httpbin.org/post");
        HttpURLConnection con = (HttpURLConnection) myPostUrl.openConnection();
        con.setRequestMethod(RequestMethods.POST.name());
        con.setRequestProperty("Content-Type", contentType);
        con.setDoOutput(true);

        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(body);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();

        System.out.println("Response Code : " + responseCode);

        return getResponse(con);

    }

    private String getResponse(HttpURLConnection con) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}

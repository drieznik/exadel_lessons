package http_example;

import http_example.http_client.HttpClientBase;
import http_example.http_client.HttpURLConnectionClient;

import java.io.IOException;
import java.util.Properties;

public class HttpConnectionExample {

    static Properties properties = new Properties();

    public static void main(String[] args) throws IOException{
        String language = "Java";

        StringBuilder builder = new StringBuilder(language);
        HttpURLConnectionClient con = new HttpURLConnectionClient();
        HttpClientBase httpClient = new HttpURLConnectionClient();
        populateProperties();

        con.sendGetRequest(getBaseUrl(), language);

        String contentType = "application/json";

        System.out.println("Response is: " + httpClient.sendPostRequest(getPostUrl(), getPostBody(), contentType));

    }

    public static String getBaseUrl(){
        return properties.getProperty("base.url");
    }

    public static String getPostUrl(){
        return properties.getProperty("post.url");
    }

    public static String getPostBody(){
        return properties.getProperty("post.body");
    }

    public static void populateProperties() {
        try {
            properties.load(HttpURLConnectionClient.class.getClassLoader().getResourceAsStream("my.resources"));
        }
        catch (IOException i){}
    }


}

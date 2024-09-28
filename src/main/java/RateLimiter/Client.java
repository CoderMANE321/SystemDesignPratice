package RateLimiter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//creates a request
public class Client {
    public void sendRequest() {
        try {
            URL url = new URL("http://localhost:8080/hello");
            URL T_url = new URL("http://local:8080/test");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            HttpURLConnection test_connection = (HttpURLConnection) T_url.openConnection();
            connection.setRequestMethod("GET");
            test_connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println("Response Body: " + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package RateLimiter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {
    private String request;
    private String message;

    public void sendRequest() {
            try {
                // Set the URL
                URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                // Set request method (GET, POST, etc.)
                connection.setRequestMethod("GET");

                // Optional: Set request headers
                connection.setRequestProperty("User-Agent", "Mozilla/5.0");

                // Get the response code (200 OK, 404 Not Found, etc.)
                int responseCode = connection.getResponseCode();
                System.out.println("Response Code: " + responseCode);

                // Read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Print the response
                System.out.println("Response Body: " + response.toString());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

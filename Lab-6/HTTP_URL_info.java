import java.net.*;
import java.io.*;
import java.util.*;

public class URLHttpInfo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a URL (e.g., https://www.google.com): ");
        String urlString = input.nextLine();

        try {
            // 1. Create URL object
            URL url = new URL(urlString);

            // 2. Open HTTP connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Optional: set request method (default is GET)
            connection.setRequestMethod("GET");

            // 3. Connect and get response info
            connection.connect();
            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();
            String requestMethod = connection.getRequestMethod();

            System.out.println("\n--- HTTP Request/Response Info ---");
            System.out.println("Request Method: " + requestMethod);
            System.out.println("Response Code: " + responseCode);
            System.out.println("Response Message: " + responseMessage);

            // 4. Print all HTTP headers
            System.out.println("\n--- HTTP Headers ---");
            Map<String, List<String>> headers = connection.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                String key = entry.getKey();
                List<String> values = entry.getValue();
                System.out.println((key != null ? key : "Status") + ": " + String.join(", ", values));
            }

            connection.disconnect();
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL!");
        } catch (IOException e) {
            System.out.println("Error connecting to URL.");
        }

        input.close();
    }
}

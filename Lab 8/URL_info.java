import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;

public class URLInfo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a URL (e.g., https://www.google.com): ");
        String urlString = input.nextLine();

        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.connect();  // optional, ensures headers are fetched

            System.out.println("\n--- URL Information ---");
            System.out.println("Protocol: " + url.getProtocol());

            String contentType = connection.getContentType();
            System.out.println("Content-Type: " + (contentType != null ? contentType : "Unknown"));

            long dateMillis = connection.getDate();
            if (dateMillis != 0) {
                System.out.println("Date: " + new Date(dateMillis));
            } else {
                System.out.println("Date: Not available");
            }

            long contentLength = connection.getContentLengthLong();  // Java 1.7+
            if (contentLength != -1) {
                System.out.println("Content Length: " + contentLength + " bytes");
            } else {
                System.out.println("Content Length: Not available");
            }

            System.out.println("\n--- Webpage Content (first few lines) ---");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            int maxLines = 10;
            int count = 0;
            while ((line = reader.readLine()) != null && count < maxLines) {
                System.out.println(line);
                count++;
            }
            reader.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            input.close();
        }
    }
}


import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WhoisLookup {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a domain name (e.g., google.com): ");
        String domain = input.nextLine();

        try {
            // 1. Connect to whois.internic.net on port 43
            Socket socket = new Socket("whois.internic.net", 43);
            System.out.println("\nConnected to whois.internic.net...");

            // 2. Send the domain name to the WHOIS server
            OutputStream out = socket.getOutputStream();
            out.write((domain + "\r\n").getBytes());
            out.flush();

            // 3. Read the WHOIS response from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            System.out.println("\n--- WHOIS Information ---");
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }

            // Close all resources
            in.close();
            out.close();
            socket.close();

        } catch (UnknownHostException e) {
            System.out.println("Error: Unknown host.");
        } catch (IOException e) {
            System.out.println("Error: Unable to connect to WHOIS server.");
        }

        input.close();
    }
}

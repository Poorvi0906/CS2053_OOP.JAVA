import java.io.*;
import java.net.*;

// ChatServer Code
public class ChatServer {
    public static void main(String[] args) {
        try {
            // 1. Create a server socket listening on port 5000
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client...");

            // 2. Accept connection from client
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // 3. Get input stream to receive messages
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String message;
            System.out.println("---- Chat Started ----");
            while ((message = in.readLine()) != null) {
                System.out.println("Client: " + message);
                if (message.equalsIgnoreCase("exit")) break; // end chat if client types "exit"
            }

            // 4. Close everything
            in.close();
            socket.close();
            serverSocket.close();
            System.out.println("Chat ended. Server closed.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}



// ChatClient Code
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try {
            // 1. Connect to the server on localhost and port 5000
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server. Type messages (type 'exit' to quit):");

            // 2. Get output stream to send messages
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner input = new Scanner(System.in);

            String message;
            while (true) {
                message = input.nextLine();
                out.println(message); // send to server
                if (message.equalsIgnoreCase("exit")) break; // stop when user types "exit"
            }

            // 3. Close everything
            out.close();
            socket.close();
            input.close();
            System.out.println("Disconnected from server.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

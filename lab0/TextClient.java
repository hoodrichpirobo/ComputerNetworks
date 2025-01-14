import java.io.*;
import java.util.*;
import java.net.*;

public class TextClient{
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("localhost", 8080);
        System.out.println("Connected to server IP address " + clientSocket.getInetAddress());

        // Get input and output streams
        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();

        // Wrap stream with Scanner and PrintWriter
        Scanner scanner = new Scanner(System.in);
        Scanner serverScanner = new Scanner(inputStream);
        PrintWriter writer = new PrintWriter(outputStream, true);

        // Send text lines to server
        while(true){
            System.out.println("Enter a line: ");
            String line = scanner.nextLine();
            writer.println(line);

            // Read response from server
            if(serverScanner.hasNextLine()){
                String response = serverScanner.nextLine();
                System.out.println("Received from server: " + response);
            }
        }
    }
}

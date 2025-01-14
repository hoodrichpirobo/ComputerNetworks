import java.io.*;
import java.net.*;
import java.util.*;

public class TextServer{
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server listening on port 8080...");

        while(true){
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connection stablished with client IP address " + clientSocket.getInetAddress());
            
            // Get input and output streams
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            // Wrap streams with Scanner and PrintWriter
            Scanner scanner = new Scanner(inputStream);
            PrintWriter writer = new PrintWriter(outputStream, true);

            // Read and write text lines
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println("Received from client: " + line);
                writer.println("Server response: " + line);
            }

            // Close client socket
            clientSocket.close();
        }
    }
}

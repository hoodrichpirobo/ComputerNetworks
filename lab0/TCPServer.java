import java.io.*;
import java.net.*;

public class TCPServer{
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server listening on port 8080...");

        while(true){
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connection stablished with client IP address " + clientSocket.getInetAddress());

            // Receive data from client
            InputStream inputStream = clientSocket.getInputStream();
            byte[] buffer = new byte[256];
            int bytesRead = inputStream.read(buffer);
            String message = new String(buffer, 0, bytesRead);
            System.out.println("Received message from client: " + message);

            // Send response back to client
            OutputStream outputStream = clientSocket.getOutputStream();
            String response = "Hello from server!";
            outputStream.write(response.getBytes());

            // Close client socket
            clientSocket.close();
        }
    }
}

import java.net.*;
import java.io.*;

public class TCPClient{
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("localhost", 8080);
        System.out.println("Connected to server IP address " + clientSocket.getInetAddress());

        // Send data to server
        OutputStream outputStream = clientSocket.getOutputStream();
        String message = "Hello from client!";
        outputStream.write(message.getBytes());

        // Receive response from server
        InputStream inputStream = clientSocket.getInputStream();
        byte[] buffer = new byte[256];
        int bytesRead = inputStream.read(buffer);
        String response = new String(buffer, 0, bytesRead);
        System.out.println("Received response from the server: " + response);

        // Close client socket
        clientSocket.close();
    }
}

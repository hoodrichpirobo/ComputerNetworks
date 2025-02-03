import java.io.*;
import java.util.*;
import java.net.*;

public class TCPEchoServer2 {
    public static void main(String[] args) {
        final int PORT = 7777;

        try{
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("ServerSocket is listening on port " + serverSocket.getLocalPort());
            System.out.println("ServerSocket bound to address: " + serverSocket.getInetAddress());

            while(true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("\nA client has connected to the server.");

                System.out.println("ServerSocket details:");
                System.out.println("  Local IP (serverSocket.getInetAddress()): " + serverSocket.getInetAddress());
                System.out.println("  Local Port (serverSocket.getLocalPort()): " + serverSocket.getLocalPort());

                System.out.println("ClientSocket details:");
                System.out.println("  Local IP (clientSocket.getLocalAddress()): " + clientSocket.getLocalAddress());
                System.out.println("  Local Port (clientSocket.getLocalPort()): " + clientSocket.getLocalPort());
                System.out.println("  Remote IP (clientSocket.getInetAddress()): " + clientSocket.getInetAddress());
                System.out.println("  Remote Port (clientSocket.getPort()): " + clientSocket.getPort());

                Scanner in = new Scanner(clientSocket.getInputStream());
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                if(in.hasNextLine()){
                    String receivedLine = in.nextLine();
                    out.println(receivedLine);
                    System.out.println("Echoed back to client: " + receivedLine);
                }

                clientSocket.close();
            }
        } catch (IOException ex) {
            System.err.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

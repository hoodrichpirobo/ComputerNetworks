import java.io.*;
import java.util.*;
import java.net.*;

public class TCPEchoServer1 {
    public static void main(String[] args) {
        final int PORT = 7777;

        try{
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Echo is listening on port " + PORT);

            while(true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("A client has connected to the server.");

                Scanner in = new Scanner(clientSocket.getInputStream());
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                if(in.hasNextLine()){
                    String receivedLine = in.nextLine();
                    out.println(receivedLine);
                }

                clientSocket.close();
            }
        } catch (IOException ex) {
            System.err.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

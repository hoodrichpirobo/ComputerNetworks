import java.io.*;
import java.net.*;
import java.util.*;

public class TCP3Client{
    public static void main(String[] args) {
        try{
            Scanner in = new Scanner(System.in);

            System.out.println("Choose the host name: ");
            String hostName = in.nextLine();
            System.out.println("Choose the port number: ");
            int port = in.nextInt();
            Socket socket = new Socket(hostName, port);
            System.out.println("Connected again!");
            socket.close();
        }catch (UnknownHostException e){
            System.out.println("Unknown server name \nError: " + e);
        }catch (IOException e){
            System.out.println("Connection is not possible \nError: " + e);
        }
    }
}

import java.io.*;
import java.net.*;

public class TCP2Client{
    public static void main(String[] args) {
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Choose the host name: ");
            String hostName = in.readLine();
            System.out.println("Choose the port number: ");
            int port = Integer.parseInt(in.readLine());
            Socket socket = new Socket(hostName, port);
            System.out.println("Connected!");
            socket.close();
        }catch (UnknownHostException e){
            System.out.println("Are u sure that's the right address? \nError: " + e);
        }catch (IOException e){
            System.out.println("Are u sure that's the right port? \nError: " + e);
        }
    }
}

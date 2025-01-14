import java.io.*;
import java.util.*;
import java.net.*;

public class EchoClient1{
    public static void main(String[] args){
        try{
            Socket s = new Socket("zoltar.redes.upv.es", 7);
            Scanner in = new Scanner(s.getInputStream());
            PrintWriter out = new PrintWriter(s.getOutputStream(), false);

            out.println("Hello, World!!!");
            if(in.hasNextLine()){
                System.out.println("Connected again!");
                System.out.println("Server response: " + in.nextLine());
            }
            s.close();
            out.close();
        }catch (UnknownHostException e){
            System.out.println("Unknown server name");
            System.out.println("Server response: " + e);
        }catch (IOException e){
            System.out.println("Connection is not possible");
            System.out.println("Server response: " + e);
        }
    }
}

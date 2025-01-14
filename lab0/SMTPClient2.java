import java.io.*;
import java.util.*;
import java.net.*;

public class SMTPClient2{
    public static void main(String[] args) {
        try{
            Socket s = new Socket("smtp.upv.es", 25);
            Scanner in = new Scanner(System.in);
            Scanner inServer = new Scanner(s.getInputStream());
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            System.out.println("Connected again!");
            System.out.println("Server response: " + inServer.nextLine());
            
            System.out.println("Enter your practice computer (rdcXX): ");
            String line = in.nextLine();

            out.print("HELO " + line + ".redes.upv.es\r\n");
            out.flush();
            System.out.println("Server response: " + inServer.nextLine());

            s.close();
            out.close();
        }catch (UnknownHostException e) {
            System.out.println("Unknown server name");
            System.out.println("Error: " + e);
        }catch (IOException e) {
            System.out.println("Connection is not possible");
            System.out.println("Error: " + e);
        }
    }
}

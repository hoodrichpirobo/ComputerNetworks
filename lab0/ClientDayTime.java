import java.io.*;
import java.net.*;
import java.util.*;

public class ClientDayTime{
    public static void main(String[] args){
        try{
            Socket s = new Socket("zoltar.redes.upv.es", 13);
            Scanner in = new Scanner(s.getInputStream());
            System.out.println(in.nextLine());
            System.out.println("Connected again!");
            s.close();
        }catch(UnknownHostException e){
            System.out.println("Unknown server name: " + e);
        }catch(IOException e){
            System.out.println("Connection is not possible: " + e);
        }
    }
}

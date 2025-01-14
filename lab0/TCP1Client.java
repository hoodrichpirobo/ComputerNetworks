import java.io.*;
import java.net.*;

public class TCP1Client{
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("www.upv.es", 80);
        System.out.println("Connected!");
        socket.close();
    }
}

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHTTP{
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("www.upv.es", 80);
        Scanner in = new Scanner(s.getInputStream());
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        out.print("GET / HTTP/1.0\r\n\r\n");
        out.flush();

        while(in.hasNextLine()){
            System.out.println(in.nextLine());
        }

        s.close();
        out.close();
    }
}

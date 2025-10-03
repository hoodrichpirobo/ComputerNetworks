import java.io.*;
import java.util.*;
import java.net.*; 

public class ClienteDayTime {
  static BufferedReader in;
  static PrintWriter out;

  public static void main(String[] args) throws Exception {
    in = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out);

    out.println("Host: ");
    out.flush();
    String host = in.readLine();

    out.println("Port: ");
    out.flush();
    int port = Integer.parseInt(in.readLine());

    Socket s = new Socket(host, port);
    Scanner scan = new Scanner(s.getInputStream());
    out.println(scan.nextLine());

    out.close();
  }
}

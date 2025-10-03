import java.io.*;
import java.net.*;
import java.util.*;

public class ClienteEco {
  static BufferedReader in;
  static PrintWriter out;

  public static void main(String[] args) throws Exception {
    in = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out, true);

    out.println("Host: ");
    String host = in.readLine();

    out.println("Port: ");
    int port = Integer.parseInt(in.readLine());

    Socket s = new Socket(host, port);

    PrintWriter outServer = new PrintWriter(s.getOutputStream(), true);
    Scanner scanServer = new Scanner(s.getInputStream());
    outServer.println(in.readLine());
    out.println(scanServer.nextLine());

    out.close();
  }
}

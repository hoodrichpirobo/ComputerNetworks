import java.net.*;
import java.io.*;
import java.util.*;

public class ClientePOP3{
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
    Scanner scanServer = new Scanner(s.getInputStream());
    out.println(scanServer.nextLine());

    PrintWriter outServer = new PrintWriter(s.getOutputStream(), true);
    outServer.print("QUIT\r\n");
    outServer.flush();

    out.println(scanServer.nextLine());
    s.close();

    out.close();
  }
}

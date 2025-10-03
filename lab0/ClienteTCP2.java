import java.io.*;
import java.net.*;

public class ClienteTCP2{
  static BufferedReader in;
  static PrintWriter out;

  public static void main(String[] args) throws Exception {
    in = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out);

    out.println("Host: ");
    out.flush();
    String host = in.readLine().trim();

    out.println("Port: ");
    out.flush();
    int port = Integer.parseInt(in.readLine().trim());

    Socket socket = new Socket(host, port);
    out.println("Conectado!");

    out.close();
  }
}

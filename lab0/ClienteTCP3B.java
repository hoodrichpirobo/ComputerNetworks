import java.io.*;
import java.net.*;

public class ClienteTCP3B{
  static BufferedReader in;
  static PrintWriter out;

  public static void main(String[] args) {
    try {
      in = new BufferedReader(new InputStreamReader(System.in));
      out = new PrintWriter(System.out, true);

      out.println("Host: ");
      String host = in.readLine();

      out.println("Port: ");
      int port  = Integer.parseInt(in.readLine());

      Socket s = new Socket(host, port);
      out.println("Conectado!");

      out.println("Remote port: " + s.getPort());
      out.println("Remote ip: " + s.getInetAddress());
      out.println("Local port: " + s.getLocalPort());
      out.println("Local ip: " + s.getLocalAddress());

      out.close();
    } catch (UnknownHostException e) {
      out.println("Are you sure that's the right host?");
      out.println(e);
      out.flush();
    } catch (IOException e) {
      out.println("Are you sure that's the right port?");
      out.println(e);
      out.flush();
    }
  }
}

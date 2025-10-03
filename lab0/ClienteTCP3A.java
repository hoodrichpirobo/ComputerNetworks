import java.io.*;
import java.net.*;

public class ClienteTCP3A{
  static BufferedReader in;
  static PrintWriter out;

  public static void main(String[] args) {
    try {
      in = new BufferedReader(new InputStreamReader(System.in));
      out = new PrintWriter(System.out);

      out.println("Host: ");
      out.flush();
      String host = in.readLine();

      out.println("Port: ");
      out.flush();
      int port  = Integer.parseInt(in.readLine());

      Socket socket = new Socket(host, port);
      out.println("Conectado!");

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

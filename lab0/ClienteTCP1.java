import java.net.*;
import java.io.*;

public class ClienteTCP1{
  static BufferedReader in;
  static PrintWriter out;

  public static void main(String[] args) throws Exception {
    in = new BufferedReader(new InputStreamReader(System.in));
    out = new PrintWriter(System.out);

    Socket socket = new Socket("158.42.180.62", 80);
    out.println("Conectado!");

    out.close();
  }
}

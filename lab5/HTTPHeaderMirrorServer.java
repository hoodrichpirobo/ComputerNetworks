import java.net.*;
import java.io.*;

public class HTTPHeaderMirrorServer{
    public static void main(String[] args) {
        final int PORT = 8080;

        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("HTTP Header Mirror Server is listening on port " + PORT);

            while(true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("A client has connected from "
                        + clientSocket.getInetAddress() + ":" + clientSocket.getPort());

                try(
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                ){
                    out.print("HTTP/1.0 200 OK\r\n");
                    out.print("Content-Type: text/plain\r\n");
                    out.print("\r\n");
                    out.flush();

                    String line;
                    while((line = in.readLine()) != null){
                        if(line.isEmpty()) break;
                        out.println(line);
                    }

                    System.out.println("Request headers echoed back to the client.");
                } catch (IOException ex) {
                    System.err.println("Error processing client connection: " + ex.getMessage());
                } finally {
                    clientSocket.close();
                }
            }
        } catch (IOException ex) {
            System.err.println("Server error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

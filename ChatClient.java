import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient {
    static class ServiceRead extends Thread {
        Socket client;

        public ServiceRead(Socket s) {
            this.client = s;
        }

        @Override
        public void run() {
            try{
                Scanner input = new Scanner(client.getInputStream());

                while(input.hasNextLine()) {
                    String line = input.nextLine();
                    System.out.println("# " + line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    client.close();
                } catch (IOException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("zoltar.redes.upv.es", 7788);
        PrintWriter output = new PrintWriter(client.getOutputStream(), true);
        Scanner sc = new Scanner(System.in);

        ServiceRead sr = new ServiceRead(client);
        sr.start();

        while(sc.hasNextLine()) {
            String line = sc.nextLine();

            if(line.equalsIgnoreCase("quit")) break;

            output.printf("%s\r\n", line);
        }

        client.close();
        sc.close();
    }
}

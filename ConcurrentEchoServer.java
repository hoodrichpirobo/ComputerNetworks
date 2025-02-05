import java.io.*;
import java.net.*;
import java.util.*;

public class ConcurrentEchoServer{
    static class Service extends Thread{
        private Socket clientSocket;

        public Service(Socket socket){
            this.clientSocket = socket;
        }

        @Override
        public void run(){
            System.out.println("Started thread: " + this.getName());

            try(
                Scanner input = new Scanner(clientSocket.getInputStream());
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            ){
                while(input.hasNextLine()){
                    String line = input.nextLine();
                    System.out.println(this.getName() + " received: " + line);

                    output.println(line);

                    if(line.equalsIgnoreCase("END")) break;
                }
            } catch (IOException ex) {
                System.err.println("Error in thread " + this.getName() + ": " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                try{
                    clientSocket.close();
                } catch (IOException ex) {
                    System.err.println("Error closing client socket in thread " + this.getName() + ": " + ex.getMessage());
                }
                System.out.println("Thread " + this.getName() + " terminated.");
            }
        }
    }

    public static void main(String[] args) {
        final int port = 7777;
        int counter = 0;

        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Concurrent Echo Server started on port " + port);

            while(true){
                Socket clientSocket = serverSocket.accept();
                counter++;

                Service echoService = new Service(clientSocket);
                echoService.setName("Client" + counter);
                echoService.start();
            }
        } catch (IOException ex) {
            System.err.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

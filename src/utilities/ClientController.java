package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientController implements Runnable{
    private Socket clientSocket;

    public ClientController(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Welcome to the wireless bus!");
            while (true) {
                String message = in.readLine();
                System.out.println(message);
                if (message.equals("exit")) {
                    System.out.println("Received a exit petition from " + clientSocket.getInetAddress().getHostAddress());
                    out.println("You can exit now");
                    break;
                }
                if(message!=null)out.println("ok, inform me when you want to exit");
                if (message == null) break;
            }
            System.out.println("Client disconnected of the bus: " + clientSocket.getInetAddress().getHostAddress());
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Error handling client: " + e);
        }
    }
}

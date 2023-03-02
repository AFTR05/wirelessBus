package utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.println("Welcome to the wireless bus!");

            while (true) {
                String message = in.readLine();
                if (message == null) break;

                System.out.println("Received message from client: " + message);
                out.println("Echo: " + message);
            }

            System.out.println("Client disconnected: " + clientSocket.getInetAddress().getHostAddress());
            clientSocket.close();

        } catch (IOException e) {
            System.out.println("Error handling client: " + e);
        }
    }
}

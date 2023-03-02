import utilities.ClientController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Bus {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Bus started");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client in board: " + clientSocket.getInetAddress().getHostAddress());
            ClientController clientHandler = new ClientController(clientSocket);
            Thread thread = new Thread(clientHandler);
            thread.start();
        }
    }
}

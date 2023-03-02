import utilities.ClientController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Bus {
    public static void main(String[] args) throws IOException {
        Logger log = Logger.getLogger(String.valueOf(Bus.class));
        ServerSocket serverSocket = new ServerSocket(8080);
        log.info("Bus started");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            log.info("Client on board: " + clientSocket.getInetAddress().getHostAddress());
            ClientController clientHandler = new ClientController(clientSocket);
            Thread thread = new Thread(clientHandler);
            thread.start();
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

        public static void main(String[] args) throws IOException {
            Socket socket = new Socket("localhost", 8080);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println(in.readLine());

            while (true) {
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                String message = userInput.readLine();
                out.println(message);
                System.out.println(in.readLine());
            }
        }

}


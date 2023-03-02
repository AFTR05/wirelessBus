import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

        public static void main(String[] args) throws IOException {
            Scanner scanner=new Scanner(System.in);
            System.out.println("Input the host: ");
            String host=scanner.nextLine();
            System.out.println("Input the port: ");
            String port=scanner.nextLine();
            Socket socket = new Socket(host, Integer.parseInt(port));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println(in.readLine());

            while (true) {
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                String message = userInput.readLine();
                out.println(message);
                System.out.println(in.readLine());
                if (message.equals("exit")){
                    System.exit(0);
                }
            }
        }

}


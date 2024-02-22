import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        final String host = "netology.homework";
        final int port = 8089;

        try(Socket socket = new Socket(host, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            String greeting = in.readLine();
            System.out.println(greeting);

            String name = scan.nextLine();
            out.println(name);

            String response = in.readLine();
            System.out.println(response);

            String ans = scan.nextLine();
            out.println(ans);

            String welcomeZone = in.readLine();
            System.out.println(welcomeZone);
        }
    }
}

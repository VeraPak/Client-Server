import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        final int port = 8089;
        System.out.println("Server started");
        try(ServerSocket serverSocket = new ServerSocket(port)){
            while(true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    out.println("Write your name");
                    final String username = in.readLine();

                    out.println("Are you child? (yes/no)");
                    final String ans = in.readLine();

                    String welcomeZone = null;
                    if(ans.equals("yes")) {
                        welcomeZone = String.format("Welcome to the kids area, %s! Let's play!", username);
                    }
                    if(ans.equals("no")){
                        welcomeZone = String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", username);
                    }
                    out.println(welcomeZone);
                }
            }
        }
    }
}


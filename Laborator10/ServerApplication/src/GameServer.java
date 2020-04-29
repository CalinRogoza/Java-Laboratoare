import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8100);
        while (true) {
            Socket socket = null;

            try {
                socket = serverSocket.accept();
                System.out.println("[SERVER] A new client joins the game: " + socket);

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                System.out.println("[SERVER] Creating and assigning a new thread for: " + socket);

                Thread thread = new ClientThread(dataInputStream, dataOutputStream, socket);

                thread.start();
            } catch (Exception exception) {
                socket.close();
                exception.printStackTrace();
            }
        }
    }
}

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            InetAddress ip = InetAddress.getLocalHost();

            Socket socket = new Socket(ip, 8100);

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            while (true) {
                System.out.println(dataInputStream.readUTF());
                String message = scanner.nextLine();
                dataOutputStream.writeUTF(message);

                if (message.equals("exit")) {
                    System.out.println("Closing this connection...");
                    socket.close();
                    System.out.println("Connection closed.");
                    break;
                } else if (message.equals("stop")) {
                    socket.close();
                    System.out.println("Server has stopped. This execution will end now.");
                    break;
                }
                else {
                    System.out.println(dataInputStream.readUTF());
                }
            }
            dataInputStream.close();
            dataOutputStream.close();
            scanner.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

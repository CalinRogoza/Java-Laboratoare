import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientThread extends Thread {
    final DataInputStream dataInputStream;
    final DataOutputStream dataOutputStream;
    final Socket socket;

    public ClientThread(DataInputStream dataInputStream, DataOutputStream dataOutputStream, Socket socket) {
        this.dataInputStream = dataInputStream;
        this.dataOutputStream = dataOutputStream;
        this.socket = socket;
    }

    public void run() {
        String receivedString;
        while (true) {
            try {
                dataOutputStream.writeUTF("Enter your option or 'exit' to terminate the execution.");
                receivedString = dataInputStream.readUTF();
                System.out.println(receivedString);

                if (receivedString.equals("exit")) {
                    System.out.println("Closing the connection...");
                    this.socket.close();
                    System.out.println("Connection closed!");
                    break;
                } else if (receivedString.equals("stop")) {
                    try {
                        this.socket.close();
                        System.out.println("Server stopped.");
                        this.dataOutputStream.close();
                        this.dataInputStream.close();
                        System.exit(0);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                } else {
                    System.out.println("Server received the request...");
                    dataOutputStream.writeUTF("Server received the request...");
                }

            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }
}
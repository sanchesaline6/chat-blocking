import java.io.IOException;
import java.net.Socket;

public class ChatClient {
    private static final String SERVER_ADRESS = "127.0.0.1";
    private Socket clientSocket;

    public void start() throws IOException {
        clientSocket = new Socket(SERVER_ADRESS, ChatServer.PORT);
    }
    public static void main(String[] args) {

        try {
            ChatClient client = new ChatClient();
            client.start();
        } catch (IOException e) {
            System.out.println("Erro ao iniciar o cliente: " + e.getMessage());
        }
    }
}

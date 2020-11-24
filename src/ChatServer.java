import java.io.IOException;
import java.net.PortUnreachableException;
import java.net.ServerSocket;

public class ChatServer {

    //evitar portas 80, 22, 21
    private final int PORT = 4000;
    private ServerSocket serverSocket;

    public void start() throws IOException {
        System.out.println("Servidor iniciado na porta: " + PORT);
        serverSocket = new ServerSocket(PORT);
    }
    public static void main(String[] args) {

        try {
            ChatServer server = new ChatServer();
            server.start();
        } catch (IOException e) {
            System.out.println("Erro ao iniciar o servidor: " + e.getMessage());
        }

        System.out.println("Servidor finalizado!");
    }
}

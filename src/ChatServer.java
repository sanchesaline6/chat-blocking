import java.io.*;
import java.net.PortUnreachableException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    //evitar portas 80, 22, 21
    public static final int PORT = 4000;
    private ServerSocket serverSocket;
    private BufferedReader in;

    public void start() throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println("Servidor iniciado na porta: " + PORT);
        clientConnectionLoop();
    }
    private void clientConnectionLoop() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente " + clientSocket.getRemoteSocketAddress() + " conectou");
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String msg = in.readLine();
            System.out.println("Mensagem recebida do cliente: " + clientSocket.getRemoteSocketAddress() + ": " + msg);
        }
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

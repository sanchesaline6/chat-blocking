import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADRESS = "127.0.0.1";
    private Socket clientSocket;
    private Scanner sc;
    private PrintWriter out;

    public ChatClient() {
        sc = new Scanner(System.in);
    }

    public void start() throws IOException {
        clientSocket = new Socket(SERVER_ADRESS, ChatServer.PORT);
        this.out = new PrintWriter(clientSocket.getOutputStream(), true);
        System.out.println("Cliente conectado ao servidor em " + SERVER_ADRESS + ": " + ChatServer.PORT);
        messageLoop();
    }
    private void messageLoop() throws IOException {
        String msg = null;

        do{
            System.out.print("Digite uma mensagem (ou 'sair' para finalilzar): ");
            msg = sc.nextLine();
            out.println(msg);
        }while (!msg.equalsIgnoreCase("sair"));
    }
    public static void main(String[] args) {

        try {
            ChatClient client = new ChatClient();
            client.start();
        } catch (IOException e) {
            System.out.println("Erro ao iniciar o cliente: " + e.getMessage());
        }

        System.out.println("Cliente finalizado");
    }
}

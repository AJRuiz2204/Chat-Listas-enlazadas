package app;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * Servidor de chat: acepta múltiples clientes y reenvía mensajes.
 */
public class ChatServer {
    private static final int PORT = 12345;
    // Para enviar a todos los clientes
    private final Set<PrintWriter> clientOutputs = ConcurrentHashMap.newKeySet();

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("ChatServer arrancado en puerto " + PORT);
        while (true) {
            Socket sock = server.accept();
            new ClientHandler(sock).start();
        }
    }

    private class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String userName;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                clientOutputs.add(out);

                // Primera línea del cliente: su nombre de usuario
                out.println("INGRESA TU NOMBRE:");
                userName = in.readLine();
                broadcast("*** " + userName + " se ha unido al chat ***");

                // Leer mensajes y reenviarlos
                String line;
                while ((line = in.readLine()) != null) {
                    broadcast(userName + ": " + line);
                }
            } catch (IOException e) {
                System.err.println("Error en cliente: " + e.getMessage());
            } finally {
                try { socket.close(); } catch (IOException ignored) {}
                clientOutputs.remove(out);
                broadcast("*** " + userName + " ha salido ***");
            }
        }
    }

    private void broadcast(String msg) {
        for (PrintWriter pw : clientOutputs) {
            pw.println(msg);
        }
        System.out.println(msg);
    }

    public static void main(String[] args) throws IOException {
        new ChatServer().start();
    }
}

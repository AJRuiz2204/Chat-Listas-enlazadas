package app;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * Cliente de chat: se conecta al servidor, envía y recibe mensajes.
 */
public class ChatClient {
    private static final String HOST = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(HOST, PORT);
        BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter    out = new PrintWriter(socket.getOutputStream(), true);
        Scanner        sc  = new Scanner(System.in);

        // Hilo para leer lo que llega del servidor
        new Thread(() -> {
            try {
                String msg;
                while ((msg = in.readLine()) != null) {
                    System.out.println(msg);
                }
            } catch (IOException e) {
                System.err.println("Conexión cerrada.");
            }
        }).start();

        // Hilo principal: enviar al servidor lo que escribas
        while (sc.hasNextLine()) {
            out.println(sc.nextLine());
        }

        socket.close();
        sc.close();
    }
}

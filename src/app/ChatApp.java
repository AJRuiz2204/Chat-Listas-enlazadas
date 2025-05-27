package app;

import service.UserService;
import service.ChatService;
import model.User;
import model.Message;

import java.util.List;
import java.util.Scanner;

/**
 * Aplicación de consola para simular un chat entre usuarios.
 */
public class ChatApp {
    private static final UserService userService = new UserService();
    private static final ChatService chatService = new ChatService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Chat Console App ===");
        while (true) {
            System.out.println();
            System.out.println("Menu:");
            System.out.println("1. Crear usuario");
            System.out.println("2. Crear chat");
            System.out.println("3. Unir usuario a chat");
            System.out.println("4. Enviar mensaje");
            System.out.println("5. Ver historial de chat");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            String opt = scanner.nextLine().trim();

            switch (opt) {
                case "1":
                    createUser();
                    break;
                case "2":
                    createChat();
                    break;
                case "3":
                    joinUserToChat();
                    break;
                case "4":
                    sendMessage();
                    break;
                case "5":
                    viewChatHistory();
                    break;
                case "6":
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
    }

    private static void createUser() {
        System.out.print("Nombre de usuario: ");
        String name = scanner.nextLine().trim();
        User user = userService.createUser(name);
        System.out.println("Usuario creado con ID: " + user.getId());
    }

    private static void createChat() {
        var chat = chatService.createChat();
        System.out.println("Chat creado con ID: " + chat.getId());
    }

    private static void joinUserToChat() {
        System.out.print("ID de chat: ");
        String chatId = scanner.nextLine().trim();
        System.out.print("ID de usuario: ");
        String userId = scanner.nextLine().trim();
        try {
            User user = userService.getUser(userId);
            chatService.addUserToChat(chatId, user);
            System.out.println("Usuario añadido al chat.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void sendMessage() {
        System.out.print("ID de chat: ");
        String chatId = scanner.nextLine().trim();
        System.out.print("ID de usuario: ");
        String senderId = scanner.nextLine().trim();
        System.out.print("Mensaje: ");
        String content = scanner.nextLine().trim();
        try {
            User sender = userService.getUser(senderId);
            chatService.sendMessage(chatId, sender, content);
            System.out.println("Mensaje enviado.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewChatHistory() {
        System.out.print("ID de chat: ");
        String chatId = scanner.nextLine().trim();
        try {
            List<Message> history = chatService.getMessages(chatId);
            System.out.println("=== Historial de chat ===");
            for (Message msg : history) {
                System.out.println(msg.toString());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

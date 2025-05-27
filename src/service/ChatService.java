package service;

import model.Chat;
import model.User;
import model.Message;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

/**
 * Servicio para orquestar chats: creación, participantes y mensajes.
 * SRP: solo contiene la lógica de negocio de chat.
 */
public class ChatService {
    private final Map<String, Chat> chats = new HashMap<>();

    /**
     * Crea un nuevo chat vacío, lo almacena y lo devuelve.
     */
    public Chat createChat() {
        Chat chat = new Chat();
        chats.put(chat.getId(), chat);
        return chat;
    }

    /**
     * Agrega un usuario a un chat existente.
     */
    public void addUserToChat(String chatId, User user) {
        Chat chat = chats.get(chatId);
        if (chat == null) {
            throw new IllegalArgumentException("Chat no encontrado: " + chatId);
        }
        chat.addParticipant(user);
    }

    /**
     * Envía un mensaje: crea el objeto Message y lo añade al historial del chat.
     */
    public void sendMessage(String chatId, User sender, String content) {
        Chat chat = chats.get(chatId);
        if (chat == null) {
            throw new IllegalArgumentException("Chat no encontrado: " + chatId);
        }
        Message msg = new Message(sender, content);
        chat.addMessage(msg);
    }

    /**
     * Recupera todos los mensajes de un chat, en orden de envío.
     */
    public List<Message> getMessages(String chatId) {
        Chat chat = chats.get(chatId);
        if (chat == null) {
            throw new IllegalArgumentException("Chat no encontrado: " + chatId);
        }
        return chat.getHistory();
    }
}

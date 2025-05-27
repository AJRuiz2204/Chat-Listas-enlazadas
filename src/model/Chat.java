package model;

import datastructure.MessageLinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Representa una conversación entre usuarios.
 */
public class Chat {
    private final String id;
    private final List<User> participants;
    private final MessageLinkedList messages;

    public Chat() {
        this.id = UUID.randomUUID().toString();
        this.participants = new ArrayList<>();
        this.messages = new MessageLinkedList();
    }

    public String getId() {
        return id;
    }

    public List<User> getParticipants() {
        return new ArrayList<>(participants);
    }

    public void addParticipant(User user) {
        if (!participants.contains(user)) {
            participants.add(user);
        }
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    /**
     * Devuelve el linked‐list completo.
     * Si prefieres sólo la lista de Message:
     *     return messages.getAll();
     */
    public MessageLinkedList getMessages() {
        return messages;
    }

    /**
     * Helper que devuelve historial como List<Message>
     */
    public List<Message> getHistory() {
        return messages.getAll();
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id='" + id + '\'' +
                ", participants=" + participants +
                '}';
    }
}

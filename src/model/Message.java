package model;

import java.time.LocalDateTime;

/**
 * Contiene el contenido de un mensaje, su emisor y la hora de envío.
 */
public class Message {
    private final User sender;
    private final String content;
    private final LocalDateTime timestamp;

    public Message(User sender, String content) {
        this.sender = sender;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public User getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " +
                sender.getName() + ": " +
                content;
    }
}

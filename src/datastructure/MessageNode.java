package datastructure;

import model.Message;

/**
 * Nodo de la lista enlazada de mensajes.
 */
public class MessageNode {
    private final Message message;
    private MessageNode next;

    public MessageNode(Message message) {
        this.message = message;
        this.next = null;
    }

    public Message getMessage() {
        return message;
    }

    public MessageNode getNext() {
        return next;
    }

    public void setNext(MessageNode next) {
        this.next = next;
    }
}

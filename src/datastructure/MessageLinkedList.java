package datastructure;

import model.Message;
import java.util.ArrayList;
import java.util.List;

/**
 * Lista enlazada personalizada para almacenar mensajes en orden de envío.
 */
public class MessageLinkedList {
    private MessageNode head;

    public MessageLinkedList() {
        this.head = null;
    }

    /**
     * Añade un mensaje al final de la lista.
     */
    public void add(Message message) {
        MessageNode newNode = new MessageNode(message);
        if (head == null) {
            head = newNode;
        } else {
            MessageNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    /**
     * Devuelve todos los mensajes en una List, en orden de inserción.
     */
    public List<Message> getAll() {
        List<Message> list = new ArrayList<>();
        MessageNode current = head;
        while (current != null) {
            list.add(current.getMessage());
            current = current.getNext();
        }
        return list;
    }
}

package service;

import model.User;

import java.util.Map;
import java.util.HashMap;

/**
 * Servicio para crear y gestionar usuarios.
 * Aplica SRP: solo gestiona la colección de usuarios.
 */
public class UserService {
    private final Map<String, User> users = new HashMap<>();

    /**
     * Crea un usuario con nombre dado, lo almacena y lo devuelve.
     */
    public User createUser(String name) {
        User user = new User(name);
        users.put(user.getId(), user);
        return user;
    }

    /**
     * Devuelve el usuario con el ID especificado, o lanza excepción si no existe.
     */
    public User getUser(String id) {
        User user = users.get(id);
        if (user == null) {
            throw new IllegalArgumentException("Usuario no encontrado: " + id);
        }
        return user;
    }
}

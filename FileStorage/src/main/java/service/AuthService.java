package service;

import model.User;
import java.util.HashMap;
import java.util.Map;

public class AuthService {

    private Map<String, User> users;

    public AuthService() {
        users = new HashMap<>();
        // Usuários predefinidos
        users.put("user1", new User("user1", "password1"));
        users.put("user2", new User("user2", "password2"));
    }

    public boolean login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.checkPassword(password)) {
            return true;
        }
        return false;
    }

    public void registerUser(String username, String password) {
        users.put(username, new User(username, password));
    }
}



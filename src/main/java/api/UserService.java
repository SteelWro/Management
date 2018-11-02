package api;

import entity.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long userId);
    User getUserByLogin(String login);

    void addUser(User user) throws FileNotFoundException;
    void removeUserById(Long userId) throws IOException;

}

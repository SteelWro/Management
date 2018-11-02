package api;

import entity.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long userId);
    User getUserByLogin(String login);

    void addUser(User user);
    void removeUserById(Long userId);

}

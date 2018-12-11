package api;

import entity.User;

import java.io.IOException;
import java.util.List;

public interface UserDao
{
    void saveUser(User user);

    void removeUserByLogin(String login) throws IOException;
    void removeUserById(Long id) throws IOException;

    List<User> getAllUsers() throws IOException;

    void updateUser(User user);




}

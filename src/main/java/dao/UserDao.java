package dao;

import entity.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserDao
{
    void saveUser(User user);
    void saveUsers(List<User> users) ;
    List<User> getAllUsers();
    User getUserByLogin(String login);
    User getUserById(Long userId);
    void removeUserByLogin(String login);
    void removeUserById(Long id);

}

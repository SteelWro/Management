package dao;

import entity.User;

import java.util.List;

public interface UserDao
{
    void saveUser(User user);
    void saveUsers(List<User> users);
    List<User> getAllUsers();
    User getUserByLogin(String login);
    User getUserById(Long userId);
    User removeUserByLogin(String login);
    User removeUserById(Long id);
}

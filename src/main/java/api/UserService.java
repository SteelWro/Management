package api;

import entity.User;
import exception.userException.UserLoginAlreadyExistException;
import exception.userException.UserShortLengthPasswordException;
import exception.userException.UserShortLoginLengthException;

import java.io.IOException;
import java.util.List;

public interface UserService {
    List<User> getAllUsers() throws IOException;

    User getUserById(Long userId) throws IOException;
    User getUserByLogin(String login) throws IOException;

    boolean addUser(User user) throws IOException, UserShortLengthPasswordException, UserShortLoginLengthException, UserLoginAlreadyExistException;
    void removeUserById(Long userId) throws IOException;
    void removeUserByName(String name) throws IOException;

    boolean isLogedConfirm(String login, String password) throws IOException;



}

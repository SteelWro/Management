package api;

import entity.User;

import java.io.FileNotFoundException;

public interface UserRegisterLoginFacade {
    boolean registerUser(User user) throws FileNotFoundException;
    boolean loginUser(String login, String password);
}

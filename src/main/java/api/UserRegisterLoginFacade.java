package api;

import entity.User;

import java.io.FileNotFoundException;

public interface UserRegisterLoginFacade {
    String registerUser(User user) throws FileNotFoundException;
    boolean loginUser(String login, String password);
}

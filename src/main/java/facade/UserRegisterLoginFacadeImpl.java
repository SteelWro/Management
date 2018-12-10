package facade;

import api.UserRegisterLoginFacade;
import api.UserService;
import entity.User;
import service.UserServiceImpl;

import java.io.FileNotFoundException;
import java.io.IOException;

public class UserRegisterLoginFacadeImpl implements UserRegisterLoginFacade {

    private static UserRegisterLoginFacade instance = null;
    UserService userService = UserServiceImpl.getInstance();

    private UserRegisterLoginFacadeImpl(){
    }

    public static UserRegisterLoginFacade getInstance(){
        if(instance == null){
            instance = new UserRegisterLoginFacadeImpl();
        }
        return instance;
    }

    public String registerUser(User user){
        try {
            userService.addUser(user);
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return " użytkownik zarejestrowany ";
    }

    public boolean loginUser(String login, String password) {
        try {
            return userService.isLogedConfirm(login,password);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

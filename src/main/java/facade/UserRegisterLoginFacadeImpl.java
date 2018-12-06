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
            return ""+userService.addUser(user);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean loginUser(String login, String password) {
        try {
            return userService.isLogedConfirm(login,password);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

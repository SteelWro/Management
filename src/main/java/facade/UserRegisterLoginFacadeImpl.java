package facade;

import api.UserRegisterLoginFacade;
import api.UserService;
import entity.User;
import service.UserServiceImpl;

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
            return " użytkownik zarejestrowany ";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public boolean loginUser(String login, String password) {
        try {
            return userService.isLogedConfirm(login,password);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String removeUser(String name){
        try{
            userService.removeUserByName(name);
            } catch (IOException e) {
            e.printStackTrace();
        }
        return "usunięto użytkownika ";
    }
}

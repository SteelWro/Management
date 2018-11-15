package facade;

import api.UserRegisterLoginFacade;
import api.UserService;
import entity.User;
import service.UserServiceImpl;

import java.io.FileNotFoundException;

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

    public boolean registerUser(User user) throws FileNotFoundException {
        return userService.addUser(user);
    }

    public boolean loginUser(String login, String password) {
        return userService.isLogedConfirm(login,password);
    }
}

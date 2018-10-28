package api;

import api.UserService;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthPasswordException;
import exception.UserShortLoginLengthException;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    public static UserServiceImpl instance = null;
    UserValidator userValidator = UserValidator.getInstance();

    private UserServiceImpl(){
    }

    public static UserServiceImpl getInstance(){
        if(instance==null){
            instance = new UserServiceImpl();
        }
        return instance;
    }

    public UserServiceImpl(List<User> users) {
        this.users = users;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User user) {
        try {
            if(userValidator.isValidate(user)){
                users.add(user);
            }
        } catch (UserLoginAlreadyExistException e) {
            e.printStackTrace();
        } catch (UserShortLengthPasswordException e) {
            e.printStackTrace();
        } catch (UserShortLoginLengthException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(Long userId) {
        for(int i=0;i<users.size();i++){
            if(users.get(i).getId().equals(userId)){
                users.remove(i); break;
            }
        }
    }
}

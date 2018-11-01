package service;

import api.UserDao;
import api.UserService;
import Validator.UserValidator;
import dao.UserDaoImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthPasswordException;
import exception.UserShortLoginLengthException;

import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService {
    public static UserServiceImpl instance = null;
    UserDao userDao = UserDaoImpl.getInstance();
    UserValidator userValidator = UserValidator.getInstance();

    private UserServiceImpl(){
    }

    public static UserServiceImpl getInstance(){
        if(instance==null){
            instance = new UserServiceImpl();
        }
        return instance;
    }

    public List<User> getAllUsers() {
        try {
            return userDao.getAllUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addUser(User user) {
        try {
            if(userValidator.isValidate(user)){
                userDao.saveUser(user);
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
        userDao.removeUserById(userId);
    }
}

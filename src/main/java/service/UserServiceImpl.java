package service;

import api.UserDao;
import api.UserService;
import validator.UserValidator;
import dao.UserDaoImpl;
import entity.User;
import exception.userException.UserLoginAlreadyExistException;
import exception.userException.UserShortLengthPasswordException;
import exception.userException.UserShortLoginLengthException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance = null;
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

    public User getUserById(Long userId) {
        return null;
    }

    public User getUserByLogin(String login) {
        return null;
    }

    public void addUser(User user) throws FileNotFoundException {
        try {
            if(userValidator.isValidate(user) && isUserByLoginExist(user.getLogin())){
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

    public void removeUserById(Long userId) throws IOException {
        userDao.removeUserById(userId);
    }

    public boolean isUserByLoginExist(String login) throws UserLoginAlreadyExistException {
        if(getUserByLogin(login) instanceof User) return true;
        else throw new UserLoginAlreadyExistException("Już istnieje taki user z takim loginem");
    }
}

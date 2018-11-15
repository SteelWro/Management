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
    private UserDao userDao = UserDaoImpl.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();

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
        List<User> users = getAllUsers();

        for(User user : users){
            if(user.getId().equals(userId)) return user;
        }
        return null;
    }

    public User getUserByLogin(String login) {
        List<User> users = getAllUsers();

        for(User user : users){
            if(user.getLogin().equals(login)) return user;
        }
        return null;
    }

    public boolean addUser(User user)  {
        try {
            if(userValidator.isValidate(user) && isUserByLoginNotExist(user.getLogin())){
                userDao.saveUser(user);
                return true;
            }
        } catch (UserLoginAlreadyExistException e) {
            e.printStackTrace();
        } catch (UserShortLengthPasswordException e) {
            e.printStackTrace();
        } catch (UserShortLoginLengthException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isLogedConfirm(String login, String password) {
        User user = getUserByLogin(login);

        if(!user.equals(null))
        {
            return user.getPassword().equals(password);
        }
        return false;
    }

    public void removeUserById(Long userId) throws IOException {
        userDao.removeUserById(userId);
    }

    public boolean isUserByLoginNotExist(String login) throws UserLoginAlreadyExistException {
        List<User> users = getAllUsers();

        for(User user : users){
            if(user.getLogin().equals(login)) throw new UserLoginAlreadyExistException("Już istnieje taki user z takim loginem");
        }

        return true;
    }
}

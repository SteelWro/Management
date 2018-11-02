package validator;

import api.UserDao;
import dao.UserDaoImpl;
import entity.User;
import exception.userException.UserLoginAlreadyExistException;
import exception.userException.UserShortLengthPasswordException;
import exception.userException.UserShortLoginLengthException;

public class UserValidator {
    //private UserDao userDao = UserDaoImpl.getInstance();
    private static UserValidator instance = null;

    public static UserValidator getInstance(){
        if(instance == null){
           instance = new UserValidator();
        }
        return instance;
    }

    public boolean isValidate(User user) throws UserShortLengthPasswordException, UserShortLoginLengthException {
        if(isLoginLengthEnough(user.getLogin()))
            throw new UserShortLoginLengthException("short login");

        if(isPasswordLengthEnough(user.getPassword()))
            throw new UserShortLengthPasswordException("short password");

//        if(isUserByLoginExist(user.getLogin()))
//            throw new UserLoginAlreadyExistException("User exist!");

        return true;
    }

//    public boolean isUserByLoginExist(String login)  {
//        User user = null;
//        if(userDao.getUserByLogin(login) instanceof User) return true;
//        return false;
//    }

    private boolean isLoginLengthEnough(String login){
        return login.length()>= 4;
    }

    private boolean isPasswordLengthEnough(String pass){
        return pass.length() >= 6;
    }
}

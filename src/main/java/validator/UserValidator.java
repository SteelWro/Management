package validator;

import api.UserDao;
import dao.UserDaoImpl;
import entity.User;
import exception.userException.UserLoginAlreadyExistException;
import exception.userException.UserShortLengthPasswordException;
import exception.userException.UserShortLoginLengthException;

public class UserValidator {

    private static UserValidator instance = null;

    public static UserValidator getInstance(){
        if(instance == null){
           instance = new UserValidator();
        }
        return instance;
    }

    public boolean isValidate(User user) throws UserShortLengthPasswordException, UserShortLoginLengthException {
        if(isLoginLengthNotEnough(user.getLogin()))
            throw new UserShortLoginLengthException("za krótki login");

        if(isPasswordLengthNotEnough(user.getPassword()))
            throw new UserShortLengthPasswordException("za krótkie hasło");

        return true;
    }



    private boolean isLoginLengthNotEnough(String login){
        return login.length() < 4;
    }

    private boolean isPasswordLengthNotEnough(String pass){
        return pass.length() < 6;
    }
}

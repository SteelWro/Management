package dao;

import entity.Product;
import entity.User;
import entity.parser.Parser;
import utils.FileUtils;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private String fileName;
    private static UserDaoImpl instance = null;

    private UserDaoImpl(){
        try{
            FileUtils.createNewFile(fileName);
        }catch (IOException e){
            System.out.println("Bad file Path");
            System.exit(-1);
        }
    }

    public static UserDaoImpl getInstance(){
        if(instance == null){
            instance = new UserDaoImpl();
        }
    return instance;
    }

    public UserDaoImpl(String fileName){
        this.fileName = fileName;
    }

    public void saveUser(User user) throws IOException {
    List<User> users = getAllUsers();
    users.add(user);
    saveUsers(users);
    }

    public void saveUsers(List<User> users) throws FileNotFoundException {
        FileUtils.clearFile(fileName);
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        for(User user : users){
            printWriter.write(user.toString() + "\n");
        }
        printWriter.close();
    }

    public List<User> getAllUsers() throws IOException {
        List<User> users = new ArrayList<User>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line = bufferedReader.readLine();

        while(line!=null){
            User user = Parser.parseStringToUser(line);
            if(user!=null){
                users.add(user);
            }
            line = bufferedReader.readLine();
        }

        bufferedReader.close();

        return users;
    }

    public User getUserByLogin(String login) throws IOException {
        List<User> users = getAllUsers();

        for(User user : users){
            if(user.getLogin().equals(login)) return user;
        }
        return null;
    }

    public User getUserById(Long userId) throws IOException {
        List<User> users = getAllUsers();

        for(User user : users){
            if(user.getLogin().equals(userId)) return user;
        }
        return null;
    }

    public void removeUserByLogin(String login) throws IOException {
        List<User> users = getAllUsers();

        for(int i=0;i<users.size();i++){
            if(users.get(i).getLogin().equals(login)) users.remove(i);
        }

        saveUsers(users);
    }

    public void removeUserById(Long id) throws IOException {
        List<User> users = getAllUsers();

        for(int i=0;i<users.size();i++){
            if(users.get(i).getId().equals(id)) users.remove(i);
        }

        saveUsers(users);
    }


}

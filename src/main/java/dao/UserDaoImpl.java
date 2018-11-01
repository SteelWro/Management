package dao;

import api.UserDao;
import entity.User;
import entity.parser.Parser;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private String fileName = "users.txt";
    private static UserDaoImpl instance = null;

    private UserDaoImpl(){
        try {
            FileUtils.createNewFile(fileName);
        } catch (IOException e) {
            System.out.println(e+": Error with creating file");
        }
    }

    public static UserDaoImpl getInstance() {
        if (instance == null) {
            instance = new UserDaoImpl();
        }
        return instance;
    }

    public void saveUser(User user) {
        List<User> users = null;
        try {
            users = getAllUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        users.add(user);
        saveUsers(users);
    }

    public void saveUsers(List<User> users){
        try {
            FileUtils.clearFile(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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

    public User getUserByLogin(String login){
        List<User> users = null;
        try {
            users = getAllUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(User user : users){
            if(user.getLogin().equals(login)) return user;
        }
        return null;
    }

    public User getUserById(Long userId) {
        List<User> users = null;
        try {
            users = getAllUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(User user : users){
            if(user.getLogin().equals(userId)) return user;
        }
        return null;
    }

    public void removeUserByLogin(String login)  {
        List<User> users = null;
        try {
            users = getAllUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i=0;i<users.size();i++){
            if(users.get(i).getLogin().equals(login)) users.remove(i);
        }

        saveUsers(users);
    }

    public void removeUserById(Long id){
        List<User> users = null;
        try {
            users = getAllUsers();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i=0;i<users.size();i++){
            if(users.get(i).getId().equals(id)) users.remove(i);
        }

        saveUsers(users);
    }


}

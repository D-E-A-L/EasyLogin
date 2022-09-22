package backend.db.manager.user;

import backend.User.Users;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadUser {

    private final String ROUTE;

    public ReadUser(String route){
        ROUTE = route;
    }

    private Users getUsers(){
        Users users = new Users();
        ObjectInputStream fileUsr;
        try{
            fileUsr = new ObjectInputStream(new FileInputStream(ROUTE));
            users = (Users) fileUsr.readObject();
            fileUsr.close();
        } catch (Exception ignored) {}
        return users;
    }

    public Users getFileUsers(){
        return getUsers();
    }
}

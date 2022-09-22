package backend.db.manager.user;

import backend.User.User;
import backend.User.Users;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteUser {
    
    private final String ROUTE;
    
    private final ReadUser READ_USER;
    
    public WriteUser(String route){
        ROUTE = route;
        READ_USER = new ReadUser(ROUTE);
        trFile();
    }

    private void trFile(){
        File nFile = new File(ROUTE);
        if(!nFile.exists()) {
            try{
                nFile.createNewFile();
            } catch (IOException ignored){}
        }
    }

    private void saveFileUserN(User user) {
        Users usr = READ_USER.getFileUsers();
        ObjectOutputStream exit;
        try{
            usr.addUsers(user);
            exit = new ObjectOutputStream(new FileOutputStream(ROUTE));
            exit.writeObject(usr);
            exit.close();
        } catch(Exception exc) {exc.printStackTrace();}
    }

    public void saveUser(User usr) {
        int r = usr.getPersonId();
        if(!READ_USER.getFileUsers().isThereKeyUser(r)){
            saveFileUserN(usr);
        }
    }
}

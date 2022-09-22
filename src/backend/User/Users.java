package backend.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Users implements Serializable {
    
    HashMap<Integer,User> users;
    
    public Users(){
        users = new HashMap<>();
    }

    private boolean keyExistUser(int ukey){
        Set<Integer> uks = users.keySet();
        List<Integer> nlist = new ArrayList<>(uks);
        return nlist.contains(ukey);
    }


    public void addUsers(User user){
        users.put(user.getPersonId(), user);
    }

    public boolean isThereKeyUser(int key){
        return keyExistUser(key);
    }

    public HashMap<Integer, User> getUsers(){
        return users;
    }

    public User getUser(int ci){
        return users.get(ci);
    }

}

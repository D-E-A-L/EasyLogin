package backend.User;

import java.io.Serializable;

public class User implements Serializable {

    private int personId;
    private String userName;
    private String password;

    public User(String usrn, String pass){
        userName = usrn;
        password = pass;
    }

    public void setPersonId(int ps){
        personId = ps;
    }

    public void setUserName(String usn){
        userName = usn;
    }

    public void setPassword(String ps) {
        password = ps;
    }

    public int getPersonId(){return personId;}

    public String getUserName(){return userName;}

    public String getPassword(){return password;}
}

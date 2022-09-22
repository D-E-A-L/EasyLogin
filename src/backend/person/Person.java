package backend.person;

import java.io.Serializable;

public class Person implements Serializable {

    private int cip;
    private final String name;
    private final String lastName;
    private final String email;

    public Person(int cipers, String n, String l, String e) {
        cip = cipers;
        name = n;
        lastName = l;
        email = e;
    }

    public void setCip(int ci){
        cip = ci;
    }

    public int getCip(){return cip;}

    public String getName(){
        return name;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

}

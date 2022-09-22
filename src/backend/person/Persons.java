package backend.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Persons implements Serializable {

    private final HashMap<Integer,Person> pers;

    public Persons(){
        pers = new HashMap<>();
    }

    public void addPerson(Person per){
        pers.put(per.getCip(), per);
    }

    public void setPerson(int cip, Person pe){
        if(!keyExist(cip)){
            pers.put(cip,pe);
        }
    }

    public HashMap<Integer, Person> getPersons(){
        return pers;
    }

    public Person getPerson(int ci){
        return pers.get(ci);
    }

    public boolean keyExist(int str){
        Set<Integer> nSet = pers.keySet();
        ArrayList<Integer> nList = new ArrayList<>(nSet);
        return nList.contains(str);
    }

}

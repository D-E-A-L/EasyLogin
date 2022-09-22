package backend.db.manager.person;

import backend.person.Persons;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadPerson {
    
    private final String ROUTE;

    public ReadPerson(String route){
        ROUTE = route;
    }

    private Persons getPersons(){
        Persons persr = new Persons();
        ObjectInputStream filePrs;
        try{
            filePrs = new ObjectInputStream(new FileInputStream(ROUTE));
            persr = (Persons) filePrs.readObject();
            filePrs.close();
        } catch (Exception ignored) {}
        return persr;
    }

     public Persons getFilePersons(){
        return getPersons();
    }
}

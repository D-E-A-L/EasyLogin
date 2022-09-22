package backend.db.manager.person;

import backend.person.Person;
import backend.person.Persons;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WritePerson {

    private final String RT_FILE;

    private final ReadPerson READ_P;

    public WritePerson(String rt){
        RT_FILE = rt;
        READ_P = new ReadPerson(rt);
        trFile();
    }

    private void trFile(){
        File nFile = new File(RT_FILE);
        if(!nFile.exists()) {
            try{
                nFile.createNewFile();
            } catch (IOException ignored){}
        }
    }

    private void saveFilePersN(Person pers) {
        Persons prs = READ_P.getFilePersons();
        ObjectOutputStream exit;
        try{
            prs.addPerson(pers);
            exit = new ObjectOutputStream(new FileOutputStream(RT_FILE));
            exit.writeObject(prs);
            exit.close();
        } catch(Exception exc) {exc.printStackTrace();}
    }

    public void savePerson(Person p) {
        if(!READ_P.getFilePersons().keyExist(p.getCip())){
            saveFilePersN(p);
        }
    }
}

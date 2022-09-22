package frontend.gui;

import backend.User.User;
import backend.db.manager.person.ReadPerson;
import backend.db.manager.person.WritePerson;
import backend.person.Person;
import backend.person.Persons;

import java.util.*;

import static backend.extras.InputControl.controlPerson;
import static backend.extras.Extras.convertToPrn;
import static backend.extras.Extras.msgPersonGetList;
import static frontend.message.HomeMsg.ERROR_ENTER;
import static frontend.message.PersonRegMsg.MSG_PERSON;

public class GuiPersonAdd {
    private Person person;
    private Persons persons;
    private final Scanner sc;

    private List<String> listMsgPer;
    private List<String> listEnter;

    private final WritePerson wpr;
    private final ReadPerson RPERSONS;
    private final GuiUserAdd gua;
    public GuiPersonAdd(String rt, String rt_user){
        listMsgPer = msgPersonGetList();
        listEnter = new ArrayList<>();
        sc = new Scanner(System.in);
        person = null;
        persons = null;
        wpr = new WritePerson(rt);
        RPERSONS = new ReadPerson(rt);
        gua = new GuiUserAdd(rt_user);
    }

    public void regPers(){
        System.out.println(MSG_PERSON.getDescription());
        String nstr = "";
        for(int i = 0; i < 4; i++) {
            System.out.println(listMsgPer.get(i));
            nstr = sc.nextLine();
            if(controlPerson(i, nstr)){
                listEnter.add(nstr);
            } else{
                System.out.println(ERROR_ENTER.getDescription());
                i = i-1;
            }
        }
        person = convertToPrn(listEnter);
        wpr.savePerson(person);
        gua.showGuiUsr(person);
        persons = RPERSONS.getFilePersons();
        listEnter = new ArrayList<>();
        showPersons(persons);
    }

    public void showPersons(Persons pers){
        Set<Integer> ns = pers.getPersons().keySet();
        List<Integer> nList = new ArrayList<>(ns);
        for (int a: nList) {
            System.out.println(a + "==>" + pers.getPerson(a).getName() + "-->" + pers.getPerson(a).getLastName());
        }
    }
}

package frontend.gui;

import backend.User.User;
import backend.db.manager.person.ReadPerson;
import backend.person.Person;
import backend.person.Persons;

import java.util.Scanner;

import static backend.extras.Extras.getPersonFromUser;
import static frontend.message.HomeMsg.BYE_LOG_USER;
import static frontend.message.HomeMsg.WELCOME_SYS;

public class GuiLoginEnter {

    private final Person PER;

    public GuiLoginEnter(String route, User user){
        Persons pers = (new ReadPerson(route)).getFilePersons();
        PER = getPersonFromUser(user, pers);
    }

    public void showLoginEnter(){
        System.out.println(PER.getName()+ " "+PER.getLastName()+" "+WELCOME_SYS.getDescription());
        Scanner scn = new Scanner(System.in);
        boolean status = true;
        while(status){
            System.out.println("1.- Profile         2.Logout");
            int n = scn.nextInt();
            if (n == 1) {
                GuiMyProfile gmp = new GuiMyProfile(PER);
                gmp.showProfile();
            } else {
                status = false;
                System.out.println(BYE_LOG_USER.getDescription());
            }
        }
    }
}

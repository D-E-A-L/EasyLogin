package frontend.gui;

import backend.person.Person;

import java.util.Scanner;

public class GuiMyProfile {

    private final Person PERSON;

    public GuiMyProfile(Person per){
        PERSON = per;
    }

    public void showProfile(){
        Scanner sc = new Scanner(System.in);
        boolean opt = true;
        while(opt) {System.out.println("1.- View profile    2.- Back");
            int op = sc.nextInt();
            if (op == 1) {
                view();
            } else {
                opt = false;
            }
        }
    }

    private void view(){
        System.out.println("Document Identity Number: "+PERSON.getCip());
        System.out.println("Name: "+PERSON.getName());
        System.out.println("Lastname: "+PERSON.getLastName());
        System.out.println("Email: "+PERSON.getEmail());
    }
}

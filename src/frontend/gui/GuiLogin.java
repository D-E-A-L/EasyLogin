package frontend.gui;

import backend.User.User;
import backend.User.Users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static backend.extras.Extras.*;
import static backend.extras.InputControl.controlUser;
import static frontend.message.HomeMsg.*;

public class GuiLogin {

    private final Users USRS;
    private final String ROUTE_PER;
    private List<String> optUser;
    private List<String> msgUser;

    public GuiLogin(Users users, String route_per){
        USRS = users;
        ROUTE_PER = route_per;
        optUser = new ArrayList<>();
        msgUser = msgUserGetList();
    }

    public void showLogin(){
        HashMap<String, User> nus = convertToLogin(USRS);
        System.out.println(LOGIN_ENTER.getDescription());
        Scanner sc = new Scanner(System.in);
        String str = "";
        for(int i = 0; i < 2; i++){
            System.out.println(msgUser.get(i));
            str = sc.nextLine();
            if(controlUser(i,str)){
                optUser.add(str);
            } else{
                System.out.println(ERROR_ENTER.getDescription());
                i = i-1;
            }
        }
        if(controlAccess(USRS,optUser.get(0), optUser.get(1))){
            GuiLoginEnter gle = new GuiLoginEnter(ROUTE_PER, nus.get(optUser.get(0)));
            gle.showLoginEnter();
        }
    }
}

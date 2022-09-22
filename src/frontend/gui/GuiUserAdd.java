package frontend.gui;

import backend.User.User;
import backend.User.Users;
import backend.db.manager.user.ReadUser;
import backend.db.manager.user.WriteUser;
import backend.person.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static backend.extras.Extras.*;
import static backend.extras.InputControl.controlUser;
import static frontend.message.HomeMsg.ERROR_ENTER;
import static frontend.message.HomeMsg.USER_ADD;

public class GuiUserAdd {

    private List<String> msgUser;
    private List<String> optUser;
    private User user;
    private Users uss;
    private final WriteUser WR_USER;
    private final ReadUser RE_USER;

    public GuiUserAdd(String route){
        user = null;
        uss = null;
        msgUser = msgUserGetList();
        optUser = new ArrayList<>();
        WR_USER = new WriteUser(route);
        RE_USER = new ReadUser(route);
    }

    public void showGuiUsr(Person per){
        Scanner sc = new Scanner(System.in);
        String str = "";
        System.out.println(USER_ADD.getDescription());
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
        user = convertToUser(per, optUser);
        WR_USER.saveUser(user);
        uss = RE_USER.getFileUsers();
        optUser = new ArrayList<>();
        showUsers(uss);
    }

    public void showUsers(Users users){
        Set<Integer> ns = users.getUsers().keySet();
        List<Integer> nList = new ArrayList<>(ns);
        for (int a: nList) {
            System.out.println(a + "==>" + users.getUser(a).getUserName()+ "-->" + users.getUser(a).getPassword());
        }
    }
}
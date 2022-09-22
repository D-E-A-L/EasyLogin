package frontend.gui;

import backend.db.manager.user.ReadUser;

import java.util.Scanner;

import static frontend.message.HomeMsg.*;

public class GuiHome {

    private final GuiPersonAdd GR;
    private final GuiLogin GLOG;

    public GuiHome(String rt,String rt_user){
        GR = new GuiPersonAdd(rt, rt_user);
        GLOG = new GuiLogin((new ReadUser(rt_user)).getFileUsers(), rt);
        showMenu();
    }

    private void showMenu(){
        System.out.println(WELCOME_SYS.getDescription());
        Scanner sc = new Scanner(System.in);

        boolean opt = true;
        while(opt){
            System.out.println(CHOOSE_OPTIONS.getDescription());
            System.out.println("1.- User register        2.- Login       3.- Exit");
            int op = sc.nextInt();
            switch (op) {
                case 1 -> GR.regPers();
                case 2 -> GLOG.showLogin();
                default -> {
                    opt = false;
                    System.out.println(BYE_HOME.getDescription());
                }
            }
        }

    }

}

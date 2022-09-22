import frontend.gui.GuiHome;

public class Main {

    private static GuiHome guih;

    public static void main(String []srt){
        guih = new GuiHome("persons.dat","users.dat");
    }
}

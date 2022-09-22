package backend.extras;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InputControl {

    public static boolean controlPerson(int n, String str){
        return switch (n) {
            case 0 -> controlEnterNumber(str);
            case 3 -> controlEnterEmail(str);
            default -> controlEnterString(str);
        };
    }

    public static boolean controlUser(int n, String str){
        return switch (n){
            case 0 -> controlEnterString(str);
            case 1 -> controlEnterPass(str);
            default -> false;
        };
    }

    private static boolean controlEnterNumber(String str){
        Pattern pat = Pattern.compile("^[0-9]*$");
        Matcher mat = pat.matcher(str);
        return (mat.matches());
    }

    private static boolean controlEnterEmail(String email){
        Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mat = pat.matcher(email);
        return (mat.find());
    }

    private static boolean controlEnterString(String str){
        Pattern pat = Pattern.compile("^[a-zA-Z]*$");
        Matcher mat = pat.matcher(str);
        return (mat.matches());
    }

    private static boolean controlEnterPass(String str){
        Pattern pat = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$");
        Matcher mat = pat.matcher(str);
        return (mat.matches());
    }

}

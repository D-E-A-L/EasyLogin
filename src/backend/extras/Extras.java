package backend.extras;

import backend.User.User;
import backend.User.Users;
import backend.person.Person;
import backend.person.Persons;
import frontend.message.PersonRegMsg;
import frontend.message.UserRegMsg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public final class Extras {

    //region Person
    /*English: Private method that converts the person message enumeration class to an ArrayList.
    * Spanish: Método privado que convierte la clase de enumeración de mensajes de persona en una ArrayList*/
    private static List<String> msgPersonConvertList() {
        List<String> list = new ArrayList<>();
        for(PersonRegMsg msg : PersonRegMsg.values()) {
            list.add(msg.getDescription());
        }
        return list;
    }

    /*English: Method that converts from a list to a person class
     *Spanish: Método que convierte una lista a una clase persona*/
    public static Person convertToPrn(List<String> list){
        return (list.size() == 4) ?
                (new Person(Integer.parseInt(list.get(0)),list.get(1), list.get(2), list.get(3))):
                null;
    }

    public static List<String> msgPersonGetList(){
        List<String> nList = new ArrayList<>();
        List<String> mlist = msgPersonConvertList();
        for(int i = 1; i < mlist.size(); i++){
            nList.add(mlist.get(i));
        }
        return nList;
    }

    /*
    * English: Get data person from an user
    * Spanish: Obtener los datos de persona desde un usuario.
    * */
    public static Person getPersonFromUser(User user, Persons persons){
        return persons.getPerson(user.getPersonId());
    }
    //endregion

    //region Users
    /*English: Method that converts the user message enumeration class to an ArrayList.
     *Spanish: Método que convierte la clase de enumeración de mensajes de user en una ArrayList*/
    private static List<String> msgUserConvertList() {
        List<String> list = new ArrayList<>();
        for(UserRegMsg msg : UserRegMsg.values()) {
            list.add(msg.getDescription());
        }
        return list;
    }

    public static List<String> msgUserGetList(){
        return msgUserConvertList();
    }

    /*English: Method that counts user messages.
     * Spanish: Metodo que cuenta los mensajes de usuarios*/
    private  static int countUserMsg(){
        return UserRegMsg.values().length;
    }

    /*English: Method that converts from a list to a users class
     *Spanish: Método que convierte una lista a una clase usuario*/
    public static User convertToUser(Person per, List<String> list){
        User usr = null;
        int n = per.getCip();
        if(list.size() <= countUserMsg() && list.size() > 0) {
            usr = new User(list.get(0), list.get(1));
            usr.setPersonId(n);
        }
        return usr;
    }
    //endregion

    //region login
    /*English: Method that converts users  to a new hashMap to access the system.
    * Spanish: Método que convierte usuarios a un nuevo hasmap para acceder al sistema*/
    private static HashMap<String, User> convertToEnterLogin(Users users){
        HashMap<String, User> rUser = new HashMap<>();
        Set<Integer> ns = users.getUsers().keySet();
        List<Integer> nList = new ArrayList<>(ns);
        for(int n: nList){
            String usrN = users.getUser(n).getUserName();
            rUser.put(usrN, users.getUser(n));
        }
        return rUser;
    }

    public static HashMap<String, User> convertToLogin(Users users){
        return convertToEnterLogin(users);
    }
    //endregion

    //region controlSession
    public static boolean controlAccess(Users users, String usr, String pss){
        ExtMethods<String> extMethods = new ExtMethods<>();
        HashMap<String, User> hashm = convertToLogin(users);
        boolean boolr = false;
        List<String> list = (List<String>) extMethods.objKeyConvertToList(hashm);
        for(String lr: list) {
            if(extMethods.elemExist( hashm, usr) && lr.equals(usr)){
                if(hashm.get(usr).getPassword().equals(pss)) {
                    boolr = true;
                }
            }
        }
        return boolr;
    }
    //endregion


}

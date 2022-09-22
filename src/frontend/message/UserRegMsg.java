package frontend.message;

public enum UserRegMsg {

    USER_NAME("ENTER YOUR  USER NAME"),
    USER_PASS("ENTER YOUR PASSWORD");

    private String desc;

    UserRegMsg(String descr) {
        desc = descr;
    }

    public String getDescription(){
        return desc;
    }

}

package frontend.message;

public enum PersonRegMsg {
    MSG_PERSON("ENTER PERSON DATA PLEASE TO ADD"),
    CI("ENTER YOUR IDENTITY DOCUMENT NUMBER"),
    NAME("ENTER YOUR NAME"),
    LASTNAME("ENTER YOUR LAST NAME"),
    EMAIL("ENTER YOUR EMAIL");

    private String description;

    PersonRegMsg(String str){
        description = str;
    }

    public String getDescription(){
        return description;
    }



}

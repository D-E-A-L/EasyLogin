package frontend.message;

public enum HomeMsg {

   MSG_LOGIN("ENTER USER DATA PLEASE TO ADD"),
   WELCOME_SYS("WELCOME TO SYSTEM"),
   CHOOSE_OPTIONS("CHOOSE OPTIONS PLEASE"),
   USER_ADD("ENTER USER DATA PLEASE TO ADD"),
   ERROR_ENTER("ERROR TO ENTER DATA"),
   LOGIN_ENTER("ENTER YOUR USER NAME AND PASSWORD FOR ACCESS TO SYSTEM"),
   LOGIN_ACCESS("ENTER YOUR USER NAME PLEASE"),
   PASSWORD_ACCESS("ENTER YOUR PASSWORD PLEASE"),
   BYE_LOG_USER("BYE, HAVE A NICE DAY"),
   BYE_HOME("BYE, THANK VERY MUCH FOR USE THIS SYSTEM");

   private String description;

   HomeMsg(String desc) {
      description = desc;
   }

   public void setDescription(String nDesc){
      description = nDesc;
   }

   public String getDescription(){return description;}
}
package db.com;

public interface Commands {

    int ADD_EVENT = 1;
    int ADD_USER = 2;
    int SHOW_EVENTS = 3;
    int SHOW_USERS = 4;

    static int commands(){
        System.out.println("Please enter " + ADD_EVENT + " to add event. ");
        System.out.println("Please enter " + ADD_USER + " to add user. ");
        System.out.println("Please enter " + SHOW_EVENTS + " to show events. ");
        System.out.println("Please enter " + SHOW_USERS + " to show users ");
        return 0;
    }


}

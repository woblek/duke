/**
 * this class represents all the UI messaged output by duke
 */
public class Ui {


    /**
     * introduction message
     */
    public void welcomeMessage(){
        String logo = "     ____        _        \n"
                + "    |  _ \\ _   _| | _____ \n"
                + "    | | | | | | | |/ / _ \\\n"
                + "    | |_| | |_| |   <  __/\n"
                + "    |____/ \\__,_|_|\\_\\___|\n";
        System.out.println("    Hello from\n" + logo);
        System.out.println("    __________________________________________________________________________________________");
        System.out.println("    Hello! I'm Duke");
        System.out.println("    What can I do for you?");
        System.out.println("    __________________________________________________________________________________________\n");
    }

    /**
     * this method is the goodbye message at the end of Duke
     */
    public void goodbyeMessage(){
        System.out.println("    __________________________________________________________________________________________\n");
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("    __________________________________________________________________________________________\n");
    }


    /**
     * this method prints an error for unkownCommand
     */
    public void unknownCommand(){
        System.out.println("    __________________________________________________________________________________________");
        System.out.println("    ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        System.out.println("    __________________________________________________________________________________________\n");
    }

    /**
     * this method prints an error for emptyString after the command
     */
    public void dialogueEmpty(String s){
        Character first = s.charAt(0);
        if(first.equals('t')){
            System.out.println("    __________________________________________________________________________________________");
            System.out.println("    ☹ OOPS!!! The description of a todo cannot be empty!");
            System.out.println("    __________________________________________________________________________________________\n");
        }

        else if(first.equals('d')){
            System.out.println("    __________________________________________________________________________________________");
            System.out.println("    ☹ OOPS!!! The description of a deadline cannot be empty!");
            System.out.println("    __________________________________________________________________________________________\n");
        }


        else if(first.equals('e')){
            System.out.println("    __________________________________________________________________________________________");
            System.out.println("    ☹ OOPS!!! The description of an event cannot be empty!");
            System.out.println("    __________________________________________________________________________________________\n");
        }
    }
}

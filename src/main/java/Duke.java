import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = "     ____        _        \n"
                + "    |  _ \\ _   _| | _____ \n"
                + "    | | | | | | | |/ / _ \\\n"
                + "    | |_| | |_| |   <  __/\n"
                + "    |____/ \\__,_|_|\\_\\___|\n";
        System.out.println("    Hello from\n" + logo);
        System.out.println("    __________________________________________________________________________________________\n");
        System.out.println("    Hello! I'm Duke\n");
        System.out.println("    What can I do for you?\n");
        System.out.println("    __________________________________________________________________________________________\n");


        String s = "null";
//        while(!s.equals("bye")){
        while(true){
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            s = myObj.nextLine();  // Read user input


            if (s.equals("bye")){
                System.out.println("    __________________________________________________________________________________________\n");
                System.out.println("    Bye. Hope to see you again soon!\n");
                System.out.println("    __________________________________________________________________________________________\n");
                return;
            }

            System.out.println("    __________________________________________________________________________________________\n");
            System.out.println("    " + s + "\n");  // Output user input
            System.out.println("    __________________________________________________________________________________________\n");

        }
    }
}

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
        int counterTaskList = 0;
        TaskforDuke[] taskList = new TaskforDuke[100];
        while(true){
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            s = myObj.nextLine();  // Read user input

            if (s.equals("bye")){
                System.out.println("    __________________________________________________________________________________________\n");
                System.out.println("    Bye. Hope to see you again soon!\n");
                System.out.println("    __________________________________________________________________________________________\n");
                return;
            }

            else if (s.equals("list")&&(counterTaskList>0)){
                System.out.println("    __________________________________________________________________________________________\n");
                System.out.println("    Here are the tasks in your list:\n");
                for(int i = 0; i < counterTaskList; i++){
                    System.out.println("    " + (i+1) + ". " + taskList[i].toString());
//                    System.out.println("    " + (i+1) + ". [" + taskList[i].type + "][" + taskList[i].getStatusIcon() + "] " + taskList[i].description + "\n");
                }
                System.out.println("    __________________________________________________________________________________________\n");
            }

            else if (s.contains("done")){
                int indexDone = Integer.parseInt(s.replaceAll("[\\D]", ""));
                if(indexDone > 0) {
                    taskList[indexDone - 1].setDone();
                    System.out.println("    __________________________________________________________________________________________\n");
                    System.out.println("    Nice! I've marked this task as done: " + "\n");
                    System.out.println("    " + taskList[indexDone - 1].toString());
//                    System.out.println("    " + taskList[indexDone - 1].getStatusIcon() + " " + taskList[indexDone - 1].description + "\n");
                    System.out.println("    __________________________________________________________________________________________\n");
                }
            }

            else if ((s.contains("todo"))){
                String sExtracted = s.replaceAll("todo ", "");
                taskList[counterTaskList] = new Todo(sExtracted);
                counterTaskList++;
                System.out.println("    __________________________________________________________________________________________\n");
                System.out.println("    Got it. I've added this task: " + sExtracted + "");
                System.out.println("      " + taskList[counterTaskList-1].toString());
                System.out.println("    You now have " + counterTaskList + " task(s) in the list.");
                System.out.println("    __________________________________________________________________________________________\n");
            }

            else if (s.contains("deadline")){
                String sExtracted = s.replaceAll("deadline ", "");
                String[] details = sExtracted.split("/", 2);
                taskList[counterTaskList] = new Deadline(details[0], details[1]);

//                System.out.println(details[0]);//checking
//                System.out.println(details[1]);//checking

                counterTaskList++;
                System.out.println("    __________________________________________________________________________________________\n");
                System.out.println("    Got it. I've added this task: " + details[0] + "");
                System.out.println("      " + taskList[counterTaskList-1].toString());
                System.out.println("    You now have " + counterTaskList + " task(s) in the list.");
                System.out.println("    __________________________________________________________________________________________\n");

            }

            else if(s.contains("event")){
                String sExtracted = s.replaceAll("event", "");
                String[] details = sExtracted.split("/", 2);
                taskList[counterTaskList] = new Event(details[0], details[1]);

//                System.out.println(details[0]);//checking
//                System.out.println(details[1]);//checking
                counterTaskList++;

                System.out.println("    __________________________________________________________________________________________\n");
                System.out.println("    Got it. I've added this task: " + details[0] + "");
                System.out.println("      " + taskList[counterTaskList-1].toString());
                System.out.println("    You now have " + counterTaskList + " task(s) in the list.");
                System.out.println("    __________________________________________________________________________________________\n");

            }



        }
    }
}

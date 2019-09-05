import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;



public class Duke {

    private static Parser prsr = new Parser();
    private static Ui ui = new Ui();
    private static Storage storage = new Storage();


    public static void main(String[] args) throws IOException {
        int counterTaskList = 0;
        ArrayList<TaskforDuke> taskList = new ArrayList<TaskforDuke>(0);


        // Get the file
        File f = new File("C:\\Users\\Lee Raiyan\\Documents\\1. NUS\\Semester 3\\CS2113T Software Engineering\\duke\\data\\dukedata.txt");

        // Check if the specified file
        // Exists or not
        if (f.exists()) {
            taskList = storage.load();
            counterTaskList = storage.counterTaskList;
        }
        else
            System.out.println("Does not Exists");



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


        String s = "null";
        while(true){
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            s = myObj.nextLine();  // Read user input

            if (s.equals("bye")){


                //save all data into text file
                createFile g = new createFile();
                g.openFile();
                g.addRecords(counterTaskList,taskList);
                g.closeFile();


                //print goodbye message
                System.out.println("    __________________________________________________________________________________________\n");
                System.out.println("    Bye. Hope to see you again soon!");
                System.out.println("    __________________________________________________________________________________________\n");
                return;
            }

            else if (s.equals("list")){
                if(counterTaskList>0) {
                    System.out.println("    __________________________________________________________________________________________");
                    System.out.println("    Here are the tasks in your list:");
                    for (int i = 0; i < counterTaskList; i++) {
                        System.out.println("    " + (i + 1) + ". " + taskList.get(i).toString());
                        //                    System.out.println("    " + (i+1) + ". [" + taskList[i].type + "][" + taskList[i].getStatusIcon() + "] " + taskList[i].description + "\n");
                    }
                    System.out.println("    __________________________________________________________________________________________\n");
                }

                else{
                    System.out.println("    __________________________________________________________________________________________");
                    System.out.println("    Your list is empty!");
                    System.out.println("    __________________________________________________________________________________________\n");
                }
            }

            else if (s.contains("done")){
                int indexDone = Integer.parseInt(s.replaceAll("[\\D]", ""));
                if(indexDone > 0) {
                    taskList.get(indexDone - 1).setDone();
                    System.out.println("    __________________________________________________________________________________________");
                    System.out.println("    Nice! I've marked this task as done: " + "\n");
                    System.out.println("    " + taskList.get(indexDone - 1).toString());
//                    System.out.println("    " + taskList[indexDone - 1].getStatusIcon() + " " + taskList[indexDone - 1].description + "\n");
                    System.out.println("    __________________________________________________________________________________________\n");
                }
            }

            else if(s.contains("delete")){

                if(taskList.size() > 0){
                    int indexDelete = Integer.parseInt(s.replaceAll("[\\D]", ""));
                    String sDelete = taskList.get(indexDelete-1).toString();
                    taskList.remove(indexDelete - 1);
                    counterTaskList--;

                    //inform user of deletion
                    System.out.println("    __________________________________________________________________________________________");
                    System.out.println("    Noted! I've removed this task: ");
                    System.out.println("    " + sDelete);
                    System.out.println("    You now have " + taskList.size() + " tasks in the list");
                    System.out.println("    __________________________________________________________________________________________\n");
                }
            }

            else if ((s.contains("todo"))){

                //to check if the string is empty
                if(prsr.isEmpty(s)){
                    ui.dialogueEmpty(s);
                    continue;
                }

                //adding the object to the object array
                String sExtracted = s.replaceAll("todo ", "");
                taskList.add(new Todo(sExtracted));
                counterTaskList++;
                System.out.println("    __________________________________________________________________________________________");
                System.out.println("    Got it. I've added this task: " + sExtracted + "");
                System.out.println("      " + taskList.get(counterTaskList - 1).toString());
                System.out.println("    You now have " + counterTaskList + " task(s) in the list.");
                System.out.println("    __________________________________________________________________________________________\n");
            }

            else if (s.contains("deadline")){
                //to check if the string is empty
                if(prsr.isEmpty(s)){
                    ui.dialogueEmpty(s);
                    continue;
                }

                //adding the object to the object array
                String sExtracted = s.replaceAll("deadline ", "");
                String[] details = sExtracted.split("/by ", 2);
                String[] dateString = details[1].split("/", 3);
                String[] timeString = dateString[2].split(" ", 2);
                Integer[] date = new Integer[4];
                date[0] = Integer.parseInt(dateString[0]);
                date[1] = Integer.parseInt(dateString[1]);
                date[2] = Integer.parseInt(timeString[0]);
                date[3] = Integer.parseInt(timeString[1]);

                taskList.add(new Deadline(details[0], date));
                counterTaskList++;


                //inform user of the new record
                System.out.println("    __________________________________________________________________________________________");
                System.out.println("    Got it. I've added this task: " + details[0] + "");
                System.out.println("      " + taskList.get(counterTaskList-1).toString());
                System.out.println("    You now have " + counterTaskList + " task(s) in the list.");
                System.out.println("    __________________________________________________________________________________________\n");

            }

            else if(s.contains("event")){
                //to check if the string is empty
                if(prsr.isEmpty(s)){
                    ui.dialogueEmpty(s);
                    continue;
                }

                //adding the object to the object array
                String sExtracted = s.replaceAll("event", "");
                String[] details = sExtracted.split("/at ", 2);
                String[] dateString = details[1].split("/", 3);
                String[] timeString = dateString[2].split(" ", 2);
                Integer[] date = new Integer[4];
                date[0] = Integer.parseInt(dateString[0]);
                date[1] = Integer.parseInt(dateString[1]);
                date[2] = Integer.parseInt(timeString[0]);
                date[3] = Integer.parseInt(timeString[1]);
                taskList.add(new Event(details[0], date));
                counterTaskList++;



                //inform user of new record
                System.out.println("    __________________________________________________________________________________________");
                System.out.println("    Got it. I've added this task: " + details[0] + "");
                System.out.println("      " + taskList.get(counterTaskList-1).toString());
                System.out.println("    You now have " + counterTaskList + " task(s) in the list.");
                System.out.println("    __________________________________________________________________________________________\n");

            }

            else if(s.contains("find")){
                String[] toFind = s.split(" ", 2);
                System.out.println("    __________________________________________________________________________________________");
                System.out.println("    Here are the matching tasks in your list:");
                for(int i = 0; i < counterTaskList; i++){
                    if(taskList.get(i).description.contains(toFind[1])){
                        System.out.println("    " + (i + 1) + ". " + taskList.get(i).toString());
                    }
                }
                System.out.println("    __________________________________________________________________________________________\n");
            }

            else{
                System.out.println("    __________________________________________________________________________________________");
                System.out.println("    ☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                System.out.println("    __________________________________________________________________________________________\n");
            }



        }
    }
}

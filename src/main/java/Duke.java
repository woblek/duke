import java.io.*;
import java.util.Formatter;
import java.util.Scanner;



public class Duke {




    public static void main(String[] args) throws IOException {
        int counterTaskList = 0;
        TaskforDuke[] taskList = new TaskforDuke[100];

        // Get the file
        File f = new File("C:\\Users\\Lee Raiyan\\Documents\\1. NUS\\Semester 3\\CS2113T Software Engineering\\duke\\data\\dukedata.txt");

        // Check if the specified file
        // Exists or not
        if (f.exists()) {
            File file = new File("C:\\Users\\Lee Raiyan\\Documents\\1. NUS\\Semester 3\\CS2113T Software Engineering\\duke\\data\\dukedata.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                Character first = st.charAt(0);
                if (first.equals('T')){

                    //splitting string
                    String[] details = st.split(",");


                    //create todo and add task
                    taskList[counterTaskList] = new Todo(details[2]);
                    if(details[1].equals("true")){
                        taskList[counterTaskList].setDone();
                    }
                    counterTaskList++;

                }

                else if (first.equals('D')){

                    //split string
                    String[] details = st.split(",");
                    String[] dateString = details[3].split("/", 3);
                    String[] timeString = dateString[2].split(" ", 2);
                    Integer[] date = new Integer[4];
                    date[0] = Integer.parseInt(dateString[0]);
                    date[1] = Integer.parseInt(dateString[1]);
                    date[2] = Integer.parseInt(timeString[0]);
                    date[3] = Integer.parseInt(timeString[1]);

                    //create and add deadline to tasklist
                    taskList[counterTaskList] = new Deadline(details[2], date);


                    //update counterTasklist
                    if(details[1].equals("true")){
                        taskList[counterTaskList].setDone();
                    }
                    counterTaskList++;
                }

                else if (first.equals('E')){

                    //split string
                    String[] details = st.split(",");
                    String[] dateString = details[3].split("/", 3);
                    String[] timeString = dateString[2].split(" ", 2);
                    Integer[] date = new Integer[4];
                    date[0] = Integer.parseInt(dateString[0]);
                    date[1] = Integer.parseInt(dateString[1]);
                    date[2] = Integer.parseInt(timeString[0]);
                    date[3] = Integer.parseInt(timeString[1]);


                    //create and add deadline to tasklist
                    taskList[counterTaskList] = new Deadline(details[2], date);


                    //update counterTasklist
                    if(details[1].equals("true")){
                        taskList[counterTaskList].setDone();
                    }
                    counterTaskList++;
                }
            }
            br.close();
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
                        System.out.println("    " + (i + 1) + ". " + taskList[i].toString());
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
                    taskList[indexDone - 1].setDone();
                    System.out.println("    __________________________________________________________________________________________");
                    System.out.println("    Nice! I've marked this task as done: " + "\n");
                    System.out.println("    " + taskList[indexDone - 1].toString());
//                    System.out.println("    " + taskList[indexDone - 1].getStatusIcon() + " " + taskList[indexDone - 1].description + "\n");
                    System.out.println("    __________________________________________________________________________________________\n");
                }
            }

            else if ((s.contains("todo"))){
                String sExtracted = s.replaceAll("todo ", "");

                //to check if the string is empty
                String checker0 = sExtracted.replaceAll("todo", "");
                String checker1 = checker0.replaceAll(" ", "");
                if(checker1.isEmpty()){
                    System.out.println("    __________________________________________________________________________________________");
                    System.out.println("    ☹ OOPS!!! The description of a todo cannot be empty!");
                    System.out.println("    __________________________________________________________________________________________\n");
                    continue;
                }

                //adding the object to the object array
                taskList[counterTaskList] = new Todo(sExtracted);
                counterTaskList++;
                System.out.println("    __________________________________________________________________________________________");
                System.out.println("    Got it. I've added this task: " + sExtracted + "");
                System.out.println("      " + taskList[counterTaskList - 1].toString());
                System.out.println("    You now have " + counterTaskList + " task(s) in the list.");
                System.out.println("    __________________________________________________________________________________________\n");
            }

            else if (s.contains("deadline")){
                String sExtracted = s.replaceAll("deadline ", "");

                //to check if the string is empty
                String checker0 = sExtracted.replaceAll("deadline", "");
                String checker1 = checker0.replaceAll(" ", "");
                if(checker1.isEmpty()){
                    System.out.println("    __________________________________________________________________________________________");
                    System.out.println("    ☹ OOPS!!! The description of a todo cannot be empty!");
                    System.out.println("    __________________________________________________________________________________________\n");
                    continue;
                }

                //adding the object to the object array
                String[] details = sExtracted.split("/by ", 2);
                String[] dateString = details[1].split("/", 3);
                String[] timeString = dateString[2].split(" ", 2);
                Integer[] date = new Integer[4];
                date[0] = Integer.parseInt(dateString[0]);
                date[1] = Integer.parseInt(dateString[1]);
                date[2] = Integer.parseInt(timeString[0]);
                date[3] = Integer.parseInt(timeString[1]);

                taskList[counterTaskList] = new Deadline(details[0], date);
                counterTaskList++;


                //inform user of the new record
                System.out.println("    __________________________________________________________________________________________");
                System.out.println("    Got it. I've added this task: " + details[0] + "");
                System.out.println("      " + taskList[counterTaskList-1].toString());
                System.out.println("    You now have " + counterTaskList + " task(s) in the list.");
                System.out.println("    __________________________________________________________________________________________\n");

            }

            else if(s.contains("event")){
                String sExtracted = s.replaceAll("event", "");

                //to check if the string is empty
                String checker0 = sExtracted.replaceAll("event", "");
                String checker1 = checker0.replaceAll(" ", "");
                if(checker1.isEmpty()){
                    System.out.println("    __________________________________________________________________________________________");
                    System.out.println("    ☹ OOPS!!! The description of a todo cannot be empty!");
                    System.out.println("    __________________________________________________________________________________________\n");
                    continue;
                }

                //adding the object to the object array
                String[] details = sExtracted.split("/at ", 2);
                String[] dateString = details[1].split("/", 3);
                String[] timeString = dateString[2].split(" ", 2);
                Integer[] date = new Integer[4];
                date[0] = Integer.parseInt(dateString[0]);
                date[1] = Integer.parseInt(dateString[1]);
                date[2] = Integer.parseInt(timeString[0]);
                date[3] = Integer.parseInt(timeString[1]);
                taskList[counterTaskList] = new Event(details[0], date);
                counterTaskList++;



                //inform user of new record
                System.out.println("    __________________________________________________________________________________________");
                System.out.println("    Got it. I've added this task: " + details[0] + "");
                System.out.println("      " + taskList[counterTaskList-1].toString());
                System.out.println("    You now have " + counterTaskList + " task(s) in the list.");
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

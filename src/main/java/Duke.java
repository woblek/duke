import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;



public class Duke {

    private static Parser prsr = new Parser();
    private static Ui ui = new Ui();
    private static Storage storage = new Storage();

    public static void main(String[] args) throws IOException {
        TaskList taskList = new TaskList();

        // Get the file
        File f = new File("C:\\Users\\Lee Raiyan\\Documents\\1. NUS\\Semester 3\\CS2113T Software Engineering\\duke\\data\\dukedata.txt");

        // Check if the specified file
        // Exists or not

        if (f.exists()) {
            taskList.setTaskList(storage.load());
        }
        else {
            System.out.println("File Not Found!");
        }

        //prints welcome message
        ui.welcomeMessage();


        String s = "null";
        while(true){
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            s = myObj.nextLine();  // Read user input

            if (s.equals("bye")){
                //save all data into text file
                createFile g = new createFile();
                g.openFile();
                g.addRecords(taskList.getTaskList().size(),taskList.getTaskList());
                g.closeFile();

                //print goodbye message
                ui.goodbyeMessage();
                return;
            }

            else if (s.equals("list")){
                taskList.list();
            }

            else if (s.contains("done")){
                taskList.done(s);
            }

            else if(s.contains("delete")){
                taskList.delete(s);
            }

            else if ((s.contains("todo"))){
                try{
                    String details = Todo.getDetails(s);
                    taskList.addTodo(details);
                }
                catch(invalidTodoException e){
                    ui.dialogueEmpty(s);
                }
            }

            else if (s.contains("deadline")){
                try{
                    Integer[] date = Deadline.getByDate(s);
                    String details = Deadline.getDetails(s);
                    taskList.addDeadline(details, date);
                }
                catch(invalidDeadlineException e){
                    ui.dialogueEmpty(s);
                }
            }

            else if(s.contains("event")){

                try{
                    Integer[] date = Event.getAtDate(s);
                    String details = Event.getDetails(s);
                    taskList.addEvent(details,date);
                }

                catch(invalidEventException e){
                    ui.dialogueEmpty(s);
                    }

            }
            else if(s.contains("find")){
                taskList.find(s);
            }
            else{
                ui.notRecognisedMessage();
            }
        }
    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
@SuppressWarnings("InfiniteLoopStatement")


public class Duke {

    private static Parser prsr = new Parser();
    private static Ui ui = new Ui();

    public static void main(String[] args){
        TaskList taskList = new TaskList();
        try{
            fileReader.populateTaskList("C:\\Users\\Lee Raiyan\\Documents\\1. NUS\\Semester 3\\CS2113T Software Engineering\\duke\\data\\dukedata.txt",taskList);
        }
        catch (IOException e){
            System.out.println("File Not Found!");
        }
        String s = "null";
        while(true){
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            s = myObj.nextLine();  // Read user input
            try {
                prsr.parseInput(s, taskList);
            }
            catch (unknownCommandException e){
                ui.unknownCommand();
            }
        }
    }
}

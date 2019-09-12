import java.io.*;
import java.lang.*;
import java.util.*;

/**
 * This class encompasses all methods required to populate the .txt file with data from the Duke tasklist
 */
public class createFile {
    private Formatter x;


    /**
     * Reads the .txt file specified in the path provided
     * throws Exception if fails
     */
    public void openFile(){
        try{
            x = new Formatter("C:\\Users\\Lee Raiyan\\Documents\\1. NUS\\Semester 3\\CS2113T Software Engineering\\duke\\data\\dukedata.txt");

        }
        catch (Exception e){
            System.out.println("Error Opening the File!!!");
        }
    }

    /**
     * fills the .txt file with date from the tasklist using format class
     * @param a
     * @param taskList
     */
    public void addRecords(Integer a, ArrayList<TaskforDuke> taskList){
        for (int i = 0; i < a; i++) {
            Character c1 = taskList.get(i).toString().charAt(1);
            if(c1.equals('T')){
                x.format("T,%s,%s\n", String.valueOf(taskList.get(i).isDone), taskList.get(i).description);
            }

            if(c1.equals('D')){
                x.format("D,%s,%s,%s\n", String.valueOf(taskList.get(i).isDone), taskList.get(i).description, taskList.get(i).getDate());
            }

            if(c1.equals('E')){
                x.format("E,%s,%s,%s\n", String.valueOf(taskList.get(i).isDone), taskList.get(i).description, taskList.get(i).getDate());
            }
        }
    }

    /**
     * closes the file
     */
    public void closeFile(){
        x.close();
    }
}

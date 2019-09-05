import java.io.*;
import java.lang.*;
import java.util.*;

public class createFile {
    private Formatter x;

    public void openFile(){
        try{
            x = new Formatter("C:\\Users\\Lee Raiyan\\Documents\\1. NUS\\Semester 3\\CS2113T Software Engineering\\duke\\data\\dukedata.txt");

        }
        catch (Exception e){
            System.out.println("Error Opening the File!!!");
        }
    }

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

    public void closeFile(){
        x.close();
    }
}

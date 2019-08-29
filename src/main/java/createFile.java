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

    public void addRecords(){
        x.format("%s | %s | %s | %s\n", "D", "0", "read novel", "June 6th");
    }

    public void closeFile(){
        x.close();
    }
}

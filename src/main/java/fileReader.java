import java.io.File;
import java.util.Scanner;

public class fileReader {
    private Scanner x;

    public void openFile(){
        try{
            x = new Scanner (new File("C:\\Users\\Lee Raiyan\\Documents\\1. NUS\\Semester 3\\CS2113T Software Engineering\\duke\\data\\dukedata.txt"));
        }
        catch(Exception e){
            System.out.println("Could not find file!!");
        }
    }
}

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class fileReader {
    private static Storage storage = new Storage();

    public static void populateTaskList(String s, TaskList taskList) throws IOException {

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

    }
}

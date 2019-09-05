import java.io.*;
import java.util.ArrayList;

public class Storage {

    public Integer counterTaskList = 0;


    public ArrayList<TaskforDuke> load() throws IOException {
        ArrayList<TaskforDuke> taskList = new ArrayList<TaskforDuke>(0);

        File file = new File("C:\\Users\\Lee Raiyan\\Documents\\1. NUS\\Semester 3\\CS2113T Software Engineering\\duke\\data\\dukedata.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            Character first = st.charAt(0);
            if (first.equals('T')){

                //splitting string
                String[] details = st.split(",");


                //create todo and add task
                taskList.add(new Todo(details[2]));
                if(details[1].equals("true")){
                    taskList.get(counterTaskList).setDone();
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
                taskList.add(new Deadline(details[2], date));
                if(details[1].equals("true")){
                    taskList.get(counterTaskList).setDone();
                }

                //update counterTasklist
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
                taskList.add(new Event(details[2], date));
                if(details[1].equals("true")){
                    taskList.get(counterTaskList).setDone();
                }


                //update counterTasklist
                counterTaskList++;
            }
        }
        br.close();
        return taskList;
    }
}

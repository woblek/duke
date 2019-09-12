import java.util.ArrayList;

public class TaskList {

    ArrayList<TaskforDuke> taskList = new ArrayList<TaskforDuke>(0);

    public TaskList(){
    }

    public void setTaskList(ArrayList<TaskforDuke> a) {
        this.taskList = a;
    }

    public ArrayList<TaskforDuke> getTaskList() {
        return taskList;
    }

    public Integer size(){
        return taskList.size();
    }

    public void addDeadline(String details,Integer[] date){
        taskList.add(new Deadline(details,date));
        System.out.println("    __________________________________________________________________________________________");
        System.out.println("    Got it. I've added this task: " + details + "");
        System.out.println("      " + taskList.get(taskList.size()-1).toString());
        System.out.println("    You now have " + taskList.size() + " task(s) in the list.");
        System.out.println("    __________________________________________________________________________________________\n");
    }
}

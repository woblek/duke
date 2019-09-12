import java.util.ArrayList;

public class TaskList {

    ArrayList<TaskforDuke> taskList = new ArrayList<TaskforDuke>(0);

    public TaskList(){
    }

    public void setTaskList(ArrayList<TaskforDuke> a) {
        this.taskList = a;
        Ui ui = new Ui();
        ui.welcomeMessage();
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

    public void addEvent(String details, Integer[] date){
        taskList.add(new Event(details,date));
        System.out.println("    __________________________________________________________________________________________");
        System.out.println("    Got it. I've added this task: " + details + "");
        System.out.println("      " + taskList.get(taskList.size()-1).toString());
        System.out.println("    You now have " + taskList.size() + " task(s) in the list.");
        System.out.println("    __________________________________________________________________________________________\n");
    }

    public void addTodo(String details){
        taskList.add(new Todo(details));
        System.out.println("    __________________________________________________________________________________________");
        System.out.println("    Got it. I've added this task: " + details + "");
        System.out.println("      " + taskList.get(taskList.size() - 1).toString());
        System.out.println("    You now have " + taskList.size() + " task(s) in the list.");
        System.out.println("    __________________________________________________________________________________________\n");
    }

    public void find(String s){
        String[] toFind = s.split(" ", 2);
        System.out.println("    __________________________________________________________________________________________");
        System.out.println("    Here are the matching tasks in your list:");
        for(int i = 0; i < taskList.size(); i++){
            if(taskList.get(i).description.contains(toFind[1])){
                System.out.println("    " + (i + 1) + ". " + taskList.get(i).toString());
            }
        }
        System.out.println("    __________________________________________________________________________________________\n");
    }

    public void list(){
        if(taskList.size()>0) {
            System.out.println("    __________________________________________________________________________________________");
            System.out.println("    Here are the tasks in your list:");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.println("    " + (i + 1) + ". " + taskList.get(i).toString());
            }
            System.out.println("    __________________________________________________________________________________________\n");
        }

        else{
            System.out.println("    __________________________________________________________________________________________");
            System.out.println("    Your list is empty!");
            System.out.println("    __________________________________________________________________________________________\n");
        }
    }

    public void done(String s){
        int indexDone = Integer.parseInt(s.replaceAll("[\\D]", ""));
        if(indexDone > 0) {
            taskList.get(indexDone - 1).setDone();
            System.out.println("    __________________________________________________________________________________________");
            System.out.println("    Nice! I've marked this task as done: ");
            System.out.println("      " + taskList.get(indexDone - 1).toString());
            System.out.println("    __________________________________________________________________________________________\n");
        }
    }

    public void delete(String s){

        if(taskList.size() > 0) {
            int indexDelete = Integer.parseInt(s.replaceAll("[\\D]", ""));
            String sDelete = taskList.get(indexDelete - 1).toString();
            taskList.remove(indexDelete - 1);

            //inform user of deletion
            System.out.println("    __________________________________________________________________________________________");
            System.out.println("    Noted! I've removed this task:");
            System.out.println("      " + sDelete);
            System.out.println("    You now have " + taskList.size() + " tasks in the list");
            System.out.println("    __________________________________________________________________________________________\n");
        }

    }
}

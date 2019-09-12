/**
 * this class represents the superclass that excompasses all types of Tasks that
 * Duke understands
 */
public class TaskforDuke {
    protected String description;
    protected boolean isDone;
    protected String type;

    /**
     * TaskforDuke() creates an instance of a task
     * @param description
     */
    public TaskforDuke(String description) {
        this.description = description;
        this.isDone = false;
//        this.type = "T";
    }

    /**
     * getStatusIcon() returns a ASCII character tick or cross based on
     * whther the task is completed
     * @return tick or cross
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * @return description
     */
    public String getDescription(){
        return description;
    }

    /**
     * @return a string telling the user
     * that Todos have no dates
     */
    public String getDate(){
        return "There is no date for Todo";
    }

    /**
     * sets the boolean for the isDone
     * of the task to be done
     */
    public void setDone(){
        isDone = true;
    }

//    public void setType(String s){
//        type = s;
//    }
    public String toString() {
        return "[" + getStatusIcon() + "] " + getDescription() ;
    }

    //...
}

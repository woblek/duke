public class TaskforDuke {
    protected String description;
    protected boolean isDone;
    protected String type;

    public TaskforDuke(String description) {
        this.description = description;
        this.isDone = false;
//        this.type = "T";
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    public String getDescription(){
        return description;
    }

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

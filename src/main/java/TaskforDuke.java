public class TaskforDuke {
    protected String description;
    protected boolean isDone;

    public TaskforDuke(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void setDone(){
        isDone = true;
    }

    //...
}

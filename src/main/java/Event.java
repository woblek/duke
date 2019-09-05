public class Event extends TaskforDuke {

    protected Integer[] at;

    public Event(String description, Integer[] at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + getDate() + ")";
    }

    @Override
    public String getDate(){
        String result = at[0] + "/" + at[1] + "/" + at[2] + " " + at[3];
        return result;
    }
}
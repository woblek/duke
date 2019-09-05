public class Deadline extends TaskforDuke {

    protected Integer[] by;

    public Deadline(String description, Integer[] by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + getDate() + ")";
    }


    @Override
    public String getDate(){
        String result = by[0] + "/" + by[1] + "/" + by[2] + " " + by[3];
        return result;
    }


}
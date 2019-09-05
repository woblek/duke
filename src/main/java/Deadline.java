public class Deadline extends TaskforDuke {

    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }


    @Override
    public String getDate(){
        return by;
    }

//    @Override
//    public void setType(String s){
//        super.setType(s);
//    }
}
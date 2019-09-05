public class Event extends TaskforDuke {

    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }

    @Override
    public String getDate(){
        return at;
    }

//    @Override
//    public void setType(String s){
//        super.setType(s);
//    }
}
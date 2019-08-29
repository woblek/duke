public class Todo extends TaskforDuke {

    protected String by;

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

//    @Override
//    public void setType(String s){
//        super.setType(s);
//    }
}

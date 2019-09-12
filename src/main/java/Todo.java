public class Todo extends TaskforDuke {

    protected String by;

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    public static String getDetails(String s) throws invalidTodoException{
        if(s.equals("todo")){
            throw new invalidTodoException();
        }
        return s.replaceAll("todo ", "");
    }

//    @Override
//    public void setType(String s){
//        super.setType(s);
//    }
}

/**
 * this class inherits from the TaskforDuke class and represents a speicifc type of
 * task that has no time attached to it
 */
public class Todo extends TaskforDuke {

    protected String by;

    /**
     * this method returns the description of the todo instance
     * @param description
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * this method builds a string of the details of the todo instance
     * @return
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * this methodd deletes all occurences of "todo"
     * @param s
     * @return string without substring "todo"
     * @throws invalidTodoException
     */
    public static String getDetails(String s) throws invalidTodoException{
        if(s.equals("todo")){
            throw new invalidTodoException();
        }
        return s.replaceAll("todo ", "");
    }

}

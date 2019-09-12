public class Parser {

    public static Ui ui = new Ui();

    public void parseInput(String s, TaskList taskList) throws unknownCommandException{

        if (s.equals("bye")){
            //save all data into text file
            createFile g = new createFile();
            g.openFile();
            g.addRecords(taskList.getTaskList().size(),taskList.getTaskList());
            g.closeFile();

            //print goodbye message
            ui.goodbyeMessage();
            System.exit(0);
        }

        else if (s.equals("list")){
            taskList.list();
        }

        else if (s.contains("done")){
            taskList.done(s);
        }

        else if(s.contains("delete")){
            taskList.delete(s);
        }

        else if ((s.contains("todo"))){
            try{
                String details = Todo.getDetails(s);
                taskList.addTodo(details);
            }
            catch(invalidTodoException e){
                ui.dialogueEmpty(s);
            }
        }

        else if (s.contains("deadline")){
            try{
                Integer[] date = Deadline.getByDate(s);
                String details = Deadline.getDetails(s);
                taskList.addDeadline(details, date);
            }
            catch(invalidDeadlineException e){
                ui.dialogueEmpty(s);
            }
        }

        else if(s.contains("event")){

            try{
                Integer[] date = Event.getAtDate(s);
                String details = Event.getDetails(s);
                taskList.addEvent(details,date);
            }

            catch(invalidEventException e){
                ui.dialogueEmpty(s);
            }

        }
        else if(s.contains("find")){
            taskList.find(s);
        }
        else{
            throw new unknownCommandException();
        }
    }
}

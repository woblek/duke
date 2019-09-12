/**
 * Deadline class inherits from TaskforDuke to represent a more specific task with a specific time to meet it
 */
public class Deadline extends TaskforDuke {

    protected Integer[] by;

    /**
     * creates an instance of Deadline
     * @param description
     * @param by
     */
    public Deadline(String description, Integer[] by) {
        super(description);
        this.by = by;
    }

    /**
     * toString builds a string in the format [D] <description> (by: <date><time>)
     * @return string with detailed information about the Deadline instance
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + getDate() + ")";
    }

    /**
     * getDate builds a string of the date in the format DD/MM/YY TTTT
     * @return result
     */
    @Override
    public String getDate(){
        String result = by[0] + "/" + by[1] + "/" + by[2] + " " + by[3];
        return result;
    }

    /**
     * extracts the date from the raw command given by the user
     * @param s
     * @return date
     * @throws invalidDeadlineException
     */
    public static Integer[] getByDate(String s) throws invalidDeadlineException{
        if(s.equals("deadline")){
            throw new invalidDeadlineException();
        }
        String sExtracted = s.replaceAll("deadline ", "");
        String[] details = sExtracted.split("/by ", 2);
        String[] dateString = details[1].split("/", 3);
        String[] timeString = dateString[2].split(" ", 2);
        Integer[] date = new Integer[4];
        date[0] = Integer.parseInt(dateString[0]);
        date[1] = Integer.parseInt(dateString[1]);
        date[2] = Integer.parseInt(timeString[0]);
        date[3] = Integer.parseInt(timeString[1]);
        return date;
    }

    /**
     * getDetails returns description of the deadline command
     * @param s
     * @return details[0]
     * @throws invalidDeadlineException
     */
    public static String getDetails(String s) throws invalidDeadlineException{
        if(s.equals("deadline")){
            throw new invalidDeadlineException();
        }
        String sExtracted = s.replaceAll("deadline ", "");
        String[] details = sExtracted.split("/by ", 2);
        return details[0];

    }


}
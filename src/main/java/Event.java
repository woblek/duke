/**
 * Event class inherits from TaskforDuke to represent a more specific task with a specific time to attend it
 */
public class Event extends TaskforDuke {

    protected Integer[] at;


    /**
     * creates an instance of Event
     * @param description
     * @param at
     */
    public Event(String description, Integer[] at) {
        super(description);
        this.at = at;
    }

    /**
     * toString builds a string in the format [D] <description> (by: <date><time>)
     * @return string with detailed information about the Deadline instance
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + getDate() + ")";
    }

    /**
     * getDate builds a string of the date in the format DD/MM/YY TTTT
     * @return result
     */
    @Override
    public String getDate(){
        String result = at[0] + "/" + at[1] + "/" + at[2] + " " + at[3];
        return result;
    }



    /**
     * extracts the date from the raw command given by the user
     * @param s
     * @return date
     * @throws invalidEventException
     */
    public static Integer[] getAtDate(String s) throws invalidEventException{
        if(s.equals("event")){
            throw new invalidEventException();
        }
        String sExtracted = s.replaceAll("event ", "");
        String[] details = sExtracted.split("/at ", 2);
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
     * @throws invalidEventException
     */
    public static String getDetails(String s) throws invalidEventException{
        if(s.equals("deadline")){
            throw new invalidEventException();
        }
        String sExtracted = s.replaceAll("event ", "");
        String[] details = sExtracted.split("/at ", 2);
        return details[0];

    }
}
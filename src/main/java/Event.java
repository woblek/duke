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


    public static String getDetails(String s) throws invalidEventException{
        if(s.equals("deadline")){
            throw new invalidEventException();
        }
        String sExtracted = s.replaceAll("event ", "");
        String[] details = sExtracted.split("/at ", 2);
        return details[0];

    }
}
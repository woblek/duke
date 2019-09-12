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
public class Parser {



    public String parseInputTodo(String s){
        return s.replaceAll("todo ", "");
    }


    public boolean isEmpty(String s){
        Character first = s.charAt(0);
        if(first.equals('t')){
            String checker0 = s.replaceAll("todo", "");
            String checker1 = checker0.replaceAll(" ", "");
            return checker1.isEmpty();
        }

        else if(first.equals('d')){
            String checker0 = s.replaceAll("deadline", "");
            String checker1 = checker0.replaceAll(" ", "");
            return checker1.isEmpty();
        }


        else if(first.equals('e')){
            String checker0 = s.replaceAll("event", "");
            String checker1 = checker0.replaceAll(" ", "");
            return checker1.isEmpty();
        }
        return false;
    }
}

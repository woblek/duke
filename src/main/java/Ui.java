public class Ui {

    public void dialogueEmpty(String s){
        Character first = s.charAt(0);
        if(first.equals('t')){
            System.out.println("    __________________________________________________________________________________________");
            System.out.println("    ☹ OOPS!!! The description of a todo cannot be empty!");
            System.out.println("    __________________________________________________________________________________________\n");
        }

        else if(first.equals('d')){
            System.out.println("    __________________________________________________________________________________________");
            System.out.println("    ☹ OOPS!!! The description of a deadline cannot be empty!");
            System.out.println("    __________________________________________________________________________________________\n");
        }


        else if(first.equals('e')){
            System.out.println("    __________________________________________________________________________________________");
            System.out.println("    ☹ OOPS!!! The description of an event cannot be empty!");
            System.out.println("    __________________________________________________________________________________________\n");
        }
    }
}

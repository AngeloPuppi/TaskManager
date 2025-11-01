import java.util.Scanner;

public class Validator {
    private Scanner keyboard = new Scanner(System.in);
    
    public String CheckString(){
        boolean Invalid = true;
        String Correct = "";
        
        while(Invalid){
            String checker = keyboard.nextLine();

            try {
            int number = Integer.parseInt(checker);
            System.out.println("Please provide a valid text");

            } catch (NumberFormatException e) {
                if(checker.isEmpty()){
                    System.out.println("Dont leave blank space please");
                }
                else{
                Invalid = false;
                Correct = checker;
                }
            }
        }
        return Correct;
    }

        public int CheckInt(int min, int max){
        boolean Invalid = true;
        int Correct = 0;

        while(Invalid){
            String checker = keyboard.nextLine();

            try {
                int number = Integer.parseInt(checker);
                if (number < min || number > max){
                    System.out.println("Please provide a valid number from " + min + " to " + max + ":");
                }
                else{
                Invalid = false;
                Correct = number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please provide a valid number");
            }
        }
        return Correct;
    }
}

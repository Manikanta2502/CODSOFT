import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args)  {
      
        Random rand = new Random();

        int randomNumber = rand.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        
    
    System.out.println("How many tries do you need??");
    System.out.println("U:Unlimited Tries");
    System.out.println("L:Limited Tries");
    char k = scanner.next().charAt(0);
    
    switch (k) {
    case 'L':

       { int chances;
        System.out.println("Enter the Maximum Number of Tries needed for you :");
        chances=scanner.nextInt();
       


        int tryCount = 0;
        while(true){
        System.out.println("Enter your Guess Number between 1 and 100:");

        int playerGuess = scanner.nextInt();
            
            
            
    
        if (playerGuess == randomNumber){
            System.out.println("Hurrah! Correct Guess");
            System.out.println("It took you " + (++tryCount) + " tries");
            break;
        }

        else if (playerGuess < randomNumber){
            System.out.println("Nope! You Entered a lower number");
        }

        else {
            System.out.println("Nope! You Entered an Higher number");
        }
        tryCount++;
            
            if(tryCount>=chances){
                System.out.println("You have Utilised your maximum tries.");
                break;
            }

    }
        scanner.close();}
        
        

        
        break;

    case 'U':{
        int tryCount = 0;
        while(true){
        System.out.println("Enter your Guess Number between 1 and 100:");

        int playerGuess = scanner.nextInt();
            tryCount++;
        if (playerGuess == randomNumber){
            System.out.println("Hurrah! Correct Guess");
            System.out.println("It took you " + tryCount + " tries");
            break;
        }

        else if (playerGuess < randomNumber){
            System.out.println("Nope! You Entered a lower number");
        }

        else {
            System.out.println("Nope! You Entered an Higher number");
        }

    }
        scanner.close();}


        break;
}}
    
}

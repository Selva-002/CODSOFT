import java.util.*;
public class SimpleNumberGuessingGame 
{

    public static void main(String[] args)
     {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int min = 1,max = 100,max_attempt = 5;
        while (true) 
        
        {
            int numberToGuess = r.nextInt(max - min + 1)+min;
            int attempts = 0;
            boolean guessedCorrectly = false;
            System.out.println("Guess the number between " + min + " and " + max );
            while (attempts < max_attempt)
             {
                System.out.print("Enter your guess number: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess < numberToGuess) 
                {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) 
                {
                    System.out.println("Too high!");
                } else 
                {
                    System.out.println("Correct! You have guessed the number.");
                    guessedCorrectly = true;
                    break;
                }
                
                System.out.println("Attempts left: " + (max_attempt - attempts));
            }

            if (!guessedCorrectly)
            {
            System.out.println("Sorry, the number is " + numberToGuess +".");
            }

            System.out.print("Play again? (yes/no): ");
            String response = sc.next().trim().toLowerCase();

            if (!response.equals("yes"))
            {
                break;
            }
        }

        System.out.println("Thanks for playing!. Come back again");
    }
}

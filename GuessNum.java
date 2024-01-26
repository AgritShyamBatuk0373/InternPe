import java.util.*;
public class GuessNum{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
       String play= "yes";
        while(play.equals("yes"))
        {
            playgame(scan);// Method call for output
            System.out.println("If you want to play the game again entered yes either no for close");
            play = scan.next().toLowerCase();

        }

        System.out.println("Thanks for playing! Good bye. See you again!");
        scan.close();
    }

    // Method print the result
        public static void playgame(Scanner scan)
        {
            Random random= new Random();
            int randNum= random.nextInt(100);
            int guess = 0;
            int tries = 0;

            //Check for guess number
            while(guess!= randNum)
            {
                System.out.println("Guess and enter the number between 1 and 100 ");
                guess = getValidGuess(scan);
                tries++;
                if(guess== randNum)
                {
                    System.out.println("Great!! you guess the correct number");
                    System.out.println("You guessed the correct number in "+tries+" tries.");

                }else if (guess>randNum)
                {
                    System.out.println(" The number you add guess is too high");

                }else
                {
                    System.out.println(" The number you add guess is too low");
                }
            }
        }
        // Method to check the valid input
        private static int getValidGuess(Scanner scan)
        {
            while (!scan.hasNextInt())
            {
            System.out.println("Invalid input. Please enter a valid number: ");
            scan.next(); // consume the invalid input
            }
                return scan.nextInt();
        }

}
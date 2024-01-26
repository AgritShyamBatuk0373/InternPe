import java.util.Random;
import java.util.Scanner;

// Enum for the possible moves in the game
enum MoveType {
    Rock, Paper, Scissors
}

// Class for a move made by a player
class Move {
    private MoveType moveType;

    public Move(MoveType moveType) {  // Constructor
        this.moveType = moveType;
    }

    // Getter for move type
    public MoveType getMoveType() {
        return moveType;
    }

    @Override
    public String toString() {
        return moveType.toString();
    }
}

// Class for a player
class Player {
    private String name;
    private Move move;

    // Constructor
    public Player(String name) {
        this.name = name;
    }

    // Getter and setter for move
    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    @Override
    public String toString() {
        return name;
    }
}

// Class for the game
class Game {
    private Player player1;
    private Player player2;
    private Player User;

    public Game(Player player1, Player player2, Player User) {
        this.player1 = player1;
        this.player2 = player2;
        this.User = User;
    }

    // Method to determine the winner of the game
    public Player play() {
        Move move1 = player1.getMove();
        Move move2 = player2.getMove();
        Move move3 = User.getMove();

        System.out.println(player1 + " plays " + move1);
        System.out.println(player2 + " plays " + move2);
        System.out.println(User + " plays " + move3);


        if ((move1.getMoveType() == move2.getMoveType()) && (move2.getMoveType() == move3.getMoveType()))
        {
            System.out.println("It's a tie!");
            return null;
        } else if ((move1.getMoveType() == MoveType.Rock && move2.getMoveType() == MoveType.Scissors && move3.getMoveType() == MoveType.Scissors) ||
                (move1.getMoveType() == MoveType.Paper && move2.getMoveType() == MoveType.Rock && move3.getMoveType() == MoveType.Rock) ||
                (move1.getMoveType() == MoveType.Scissors && move2.getMoveType() == MoveType.Paper && move3.getMoveType() == MoveType.Paper))
        {
            System.out.println(player1 + " wins!");
            return player1;
        } else if ((move2.getMoveType() == MoveType.Rock && move1.getMoveType() == MoveType.Scissors && move3.getMoveType() == MoveType.Scissors) ||
                (move2.getMoveType() == MoveType.Paper && move1.getMoveType() == MoveType.Rock && move3.getMoveType() == MoveType.Rock) ||
                (move2.getMoveType() == MoveType.Scissors && move1.getMoveType() == MoveType.Paper && move3.getMoveType() == MoveType.Paper))
        {
            System.out.println(player2 + " wins!");
            return player2;
        } else
        {
            System.out.println(User + " wins!");
            return User;
        }
    }
}

public class RockPaperScissor
{
    public static void main(String[] args)
    {
        // Create players
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player User = new Player("User");

        // Get moves from players
        player1.setMove(getRandomMove());
        player2.setMove(getRandomMove());

        // Get user input for Player 3's move
        User.setMove(getUserMove());

        // Create and play the game
        Game game = new Game(player1, player2, User);
        Player winner = game.play();

        // Display the winner
        if (winner != null) {
            System.out.println("The winner is: " + winner);
        } else {
            System.out.println("No winner - it's a tie!");
        }
    }

    // Method to get a random move for a player
    private static Move getRandomMove()
    {
        MoveType[] moveTypes = MoveType.values();
        Random random = new Random();
        return new Move(moveTypes[random.nextInt(moveTypes.length)]);
    }

    // Method to get user input for move
    private static Move getUserMove()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your move (Rock, Paper, or Scissors): ");
        String userInput = scanner.nextLine().trim().toLowerCase();

        switch (userInput) {
            case "rock":
                return new Move(MoveType.Rock);
            case "paper":
                return new Move(MoveType.Paper);
            case "scissors":
                return new Move(MoveType.Scissors);
            default:
                System.out.println("Invalid input. Defaulting to Rock.");
                return new Move(MoveType.Rock);
        }
    }
}

import java.util.Scanner;

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] options = {"rock", "paper", "scissors"};
        int userWins = 0, compWins = 0;

        System.out.print("Enter number of games: ");
        int games = scanner.nextInt();

        for (int i = 0; i < games; i++) {
            System.out.print("Enter your choice (rock/paper/scissors): ");
            String user = scanner.next().toLowerCase();
            String comp = options[(int)(Math.random() * 3)];

            System.out.println("Computer chose: " + comp);

            if (user.equals(comp)) {
                System.out.println("Draw");
            } else if ((user.equals("rock") && comp.equals("scissors")) ||
                       (user.equals("paper") && comp.equals("rock")) ||
                       (user.equals("scissors") && comp.equals("paper"))) {
                userWins++;
                System.out.println("You win!");
            } else {
                compWins++;
                System.out.println("Computer wins!");
            }
        }

        System.out.println("User Wins: " + userWins);
        System.out.println("Computer Wins: " + compWins);
        System.out.printf("User Win %%: %.2f%%\n", (userWins * 100.0 / games));
        System.out.printf("Computer Win %%: %.2f%%\n", (compWins * 100.0 / games));

        scanner.close();
    }
}

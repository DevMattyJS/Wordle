import java.util.Scanner;

public class Wordle {

    private String secretWord;
    private int attempts;

    public Wordle(String secretWord, int attempts) {
        this.secretWord = secretWord;
        this.attempts = attempts;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean isGameOver = false;
        while(!isGameOver) {
            System.out.println("Please, make your guess. Secret word is 5 characters long.");
            String guess = scanner.nextLine();
            if (this.secretWord.equalsIgnoreCase(guess)) {
                System.out.printf("Congratulations, you guessed the secret word: %s.\n", secretWord);
                isGameOver = true;
            } else {
                System.out.println("That's not correct. Try again!");
                attempts--;
            }
        }
    }
}

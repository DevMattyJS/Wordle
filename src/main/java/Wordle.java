import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Wordle {

    private String secretWord;
    private int attempts;
    private List<String> possibleWords;
    private WordExtractor wordExtractor = new WordExtractor();

    public Wordle() {
        Random random = new Random();
        this.possibleWords = wordExtractor.getWordsList();
        this.secretWord = possibleWords.get(random.nextInt(possibleWords.size()));
        this.attempts = 6;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int remainingAttempts = attempts;

        while(remainingAttempts > 0) {
//            System.out.printf("Secret word: %s\n", secretWord);
            System.out.printf("Attempts remaining: %d\n", remainingAttempts);
            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine();

            if (guess.length() != secretWord.length()) {
                System.out.println("Invalid guess. Please enter a word with the same length as the secret word.");
                continue;
            }

            if (!isAllLetters(guess)) {
                System.out.println("Invalid guess! Just letters are allowed.");
                continue;
            }

            int correctChars = 0;
            int correctPositions = 0;

            for (int i = 0; i < secretWord.length(); i++) {
                char c = guess.charAt(i);
                if (c == secretWord.charAt(i)) {
                    correctPositions++;
                } else if (secretWord.indexOf(c) >= 0) {
                    correctChars++;
                }
            }

            if (correctPositions == secretWord.length()) {
                System.out.printf("Congratulations! You guessed the secret word: %s\n", secretWord);
                break;
            } else {
                System.out.printf("Correct characters: %d\n", correctChars);
                System.out.printf("Correct positions: %d\n", correctPositions);
                remainingAttempts--;
            }

            if (remainingAttempts == 0) {
                System.out.printf("Game Over! You are out of attempts. The secret word was: %s\n", secretWord);
            }
        }
    }

    public boolean isAllLetters(String input) {
        for (int i = 0; i < input.length(); i++) {
            char currentLetter = input.charAt(i);
            if (!Character.isLetter(currentLetter)) {
                return false;
            }
        }

        return true;
    }

}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordExtractor {

    private List<String> wordsList;

    public WordExtractor() {
        List<String> words = getWordsFromFile("nouns.txt");
        this.wordsList = fiveLetterWords(words);
    }

    public List<String> getWordsList() {
        return wordsList;
    }

    private List<String> getWordsFromFile(String fileName) {
        List<String> words = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
            String word = bf.readLine();
            while (word != null) {
                words.add(word);
                word = bf.readLine();
            }
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        return words;
    }

    private List<String> fiveLetterWords(List<String> list) {

        List<String> filteredList = list.stream()
                .filter(word -> word.length() == 5)
                .toList();

        return filteredList;
    }
}

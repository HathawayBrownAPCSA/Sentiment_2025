import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Write a description of class WordList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WordList
{
    // instance variables - replace the example below with your own
    private ArrayList<Word> words = new ArrayList<Word>();

    /**
     * Constructor for objects of class WordList
     */
    public WordList(String path)
    {
         try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            // Read each line from the file
            while ((line = br.readLine()) != null) {
                words.add(new Word(line));
            }

            // Print the data we read
            System.out.println("\nData read from CSV file:");
            for (Word w : words) {
                System.out.println("word : " + w.getWord() + "\nsentiment : " + w.getSentiment());
            }

        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public double getSentiment(String w) {
        int low = 0;
        int high = words.size();
        int guess = (low + high) / 2;
        while (low <= high) {
            Word g = words.get(guess);
            if (g.getWord().compareTo(w) > 0) {
                high = guess - 1;
            } else if (g.getWord().compareTo(w) < 0) {
                low = guess + 1;
            } else {
                return g.getSentiment();
            }
            guess = (low + high) / 2;
        }
        return 0;
    }
}

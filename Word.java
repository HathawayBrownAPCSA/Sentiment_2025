
/**
 * Write a description of class Word here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Word
{
    private String word;
    private double sentiment;
    
    public Word(String w)
    {
        word = w.substring(0,w.indexOf(","));
        String sentimentString = w.substring(w.indexOf(",") + 1);
        sentiment = Double.parseDouble(sentimentString);
    }
    
    public double getSentiment()
    {
        return sentiment;
    }
    
    public String getWord()
    {
        return word;
    }
}

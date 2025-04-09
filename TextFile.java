
/**
 * Read a text file and return individual words
 *
 * @author  Michael Buescher
 * @version 2024-04-03
 */

import java.util.Scanner;
import java.io.*;

public class TextFile
{
    Scanner input;
    
    public TextFile (String fileName)
    {  
        File f = new File(fileName);
        input = null;
        try 
        {
            input = new Scanner(f);
        }
        catch(Exception e)
        {
            System.out.println("Unable to locate " + fileName);
            System.exit(1);   // quit the program
        }

    }

    public String getNextWord()
    {
        if (input.hasNext())
        {
            // consider cleaning the word either here or elsewhere
            return input.next();
        }
        else
        {
            input.close();
            return null;
        }
    }
}

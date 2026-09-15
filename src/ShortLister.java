import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * ShortLister.java
 * Lets the user pick a text file with a JFileChooser, then uses a
 * ShortWordFilter (through the Filter interface) to print only the words
 * from that file that are shorter than 5 characters.
 *
 * @author Kirby Fortney
 */
public class ShortLister
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Choose a text file to scan for short words");

        int result = chooser.showOpenDialog(null);
        if (result != JFileChooser.APPROVE_OPTION)
        {
            System.out.println("No file selected. Exiting.");
            return;
        }

        File selectedFile = chooser.getSelectedFile();

        // Declared as the Filter interface type, even though a ShortWordFilter
        // is what's actually created — this is the point of the assignment:
        // ShortLister only needs to know about accept(Object), not the
        // specific filtering rule.
        Filter shortWordFilter = new ShortWordFilter();

        System.out.println("Short words (length < 5) found in " + selectedFile.getName() + ":");
        System.out.println("--------------------------------------------------------------");

        int count = 0;
        try (Scanner fileScanner = new Scanner(selectedFile))
        {
            while (fileScanner.hasNext())
            {
                String word = fileScanner.next();

                // Strip surrounding punctuation so "cat," and "cat" are treated the same
                String cleanWord = word.replaceAll("[^a-zA-Z0-9']", "");

                if (!cleanWord.isEmpty() && shortWordFilter.accept(cleanWord))
                {
                    System.out.println(cleanWord);
                    count++;
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Could not open file: " + e.getMessage());
            return;
        }

        System.out.println("--------------------------------------------------------------");
        System.out.println("Total short words found: " + count);
    }
}

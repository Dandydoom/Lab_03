import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * BigRectLister.java
 * Builds an ArrayList of 10 java.awt.Rectangle objects — several with a
 * perimeter of 10 or under, several well over — and uses a
 * BigRectangleFilter (through the Filter interface) to list only the ones
 * with a perimeter greater than 10.
 *
 * @author Kirby Fortney
 */
public class BigRectLister
{
    public static void main(String[] args)
    {
        ArrayList<Rectangle> rectangles = new ArrayList<>();

        // Small rectangles: perimeter = 2*(width+height) <= 10
        rectangles.add(new Rectangle(1, 1));   // perimeter = 4
        rectangles.add(new Rectangle(2, 1));   // perimeter = 6
        rectangles.add(new Rectangle(2, 2));   // perimeter = 8
        rectangles.add(new Rectangle(3, 2));   // perimeter = 10 (not > 10 -> excluded)

        // Big rectangles: perimeter > 10
        rectangles.add(new Rectangle(4, 3));   // perimeter = 14
        rectangles.add(new Rectangle(5, 4));   // perimeter = 18
        rectangles.add(new Rectangle(6, 5));   // perimeter = 22
        rectangles.add(new Rectangle(10, 10)); // perimeter = 40
        rectangles.add(new Rectangle(1, 20));  // perimeter = 42
        rectangles.add(new Rectangle(8, 7));   // perimeter = 30

        // Declared as the Filter interface type — BigRectLister only needs
        // accept(Object); it doesn't care that the rule is "perimeter > 10".
        Filter bigRectangleFilter = new BigRectangleFilter();

        System.out.println("All rectangles:");
        for (Rectangle r : rectangles)
        {
            double perimeter = 2 * (r.getWidth() + r.getHeight());
            System.out.printf("  %-24s perimeter = %.1f%n", r, perimeter);
        }

        System.out.println();
        System.out.println("Rectangles with perimeter > 10:");
        System.out.println("--------------------------------");

        int count = 0;
        for (Rectangle r : rectangles)
        {
            if (bigRectangleFilter.accept(r))
            {
                double perimeter = 2 * (r.getWidth() + r.getHeight());
                System.out.printf("  %-24s perimeter = %.1f%n", r, perimeter);
                count++;
            }
        }

        System.out.println("--------------------------------");
        System.out.println("Total big rectangles found: " + count);
    }
}

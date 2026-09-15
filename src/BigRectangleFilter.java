import java.awt.Rectangle;

/**
 * BigRectangleFilter.java
 * A Filter implementation that accepts java.awt.Rectangle objects whose
 * perimeter is greater than 10. Uses the existing java.awt.Rectangle class
 * rather than a custom one, per the assignment.
 *
 * @author Kirby Fortney
 */
public class BigRectangleFilter implements Filter
{
    /**
     * Accepts the given object if it is a Rectangle with a perimeter greater
     * than 10. Perimeter is calculated as 2 * (width + height).
     *
     * @param x the object to test — expected to be a java.awt.Rectangle
     * @return true if x is a Rectangle with perimeter &gt; 10, false otherwise
     */
    @Override
    public boolean accept(Object x)
    {
        if (!(x instanceof Rectangle))
        {
            return false;
        }

        Rectangle rect = (Rectangle) x;
        double perimeter = 2 * (rect.getWidth() + rect.getHeight());
        return perimeter > 10;
    }
}

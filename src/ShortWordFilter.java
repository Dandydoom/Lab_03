/**
 * ShortWordFilter.java
 * A Filter implementation that accepts String objects whose length is
 * less than 5 characters — i.e., "short" words.
 *
 * @author Kirby Fortney
 */
public class ShortWordFilter implements Filter
{
    /**
     * Accepts the given object if it is a String shorter than 5 characters.
     *
     * @param x the object to test — expected to be a String
     * @return true if x is a String with length &lt; 5, false otherwise
     */
    @Override
    public boolean accept(Object x)
    {
        if (!(x instanceof String))
        {
            return false;
        }

        String word = (String) x;
        return word.length() < 5;
    }
}

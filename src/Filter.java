/**
 * Filter.java
 * A callback interface for testing whether an arbitrary Object satisfies
 * some condition. Each implementation decides what "accept" means for the
 * particular kind of object it filters (a predicate-style interface).
 *
 * @author Kirby Fortney
 */
public interface Filter
{
    /**
     * Tests whether the given object satisfies this filter's condition.
     *
     * @param x the object to test
     * @return true if the object is accepted by this filter, false otherwise
     */
    boolean accept(Object x);
}

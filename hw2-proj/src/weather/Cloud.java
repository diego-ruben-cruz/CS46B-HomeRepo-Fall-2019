package weather;

/**
 * Write a description of class Cloud here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cloud
{
    // instance variables - replace the example below with your own
    private float bottom;
    private float top;

    /**
     * Constructor for objects of class Cloud
     */
    public Cloud(float givenB, float givenT)
    {
        bottom = givenB;
        top = givenT;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public float getHeight()
    {
       return (top - bottom);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String rain()
    {
       return "It is raining";
    }
}
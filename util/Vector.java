package util;


/**
 * Write a description of class Vector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vector
{
    // instance variables - replace the example below with your own
    private final int x;
    private final int y;
    private final int z;

    /**
     * Constructor for objects of class Vector
     */
    public Vector(int x,int y)
    {
        this.x=x;
        this.y=y;
        this.z=0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public double lange(Vector v)
    {
       double l=Math.sqrt((x-v.x)*(x-v.x)+(y-v.y*y-v.y));
       return l;
    }

    
}

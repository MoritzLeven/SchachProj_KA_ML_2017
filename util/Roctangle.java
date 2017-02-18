package util;


/**
 * Write a description of class Roctangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Roctangle
{
    // instance variables - replace the example below with your own
     int x,y,x2,y2,width;
     double degree,a;
    /**
     * Constructor for objects of class Roctangle
     */
    public Roctangle(int x,int y,int x2,int y2,int width)
    {
       this.x=x;
       this.y=y;
       this.x2=x2;
       this.y2=y2;
       this.width=width;
       degree=Math.toDegrees(Math.acos(Math.abs(x-x2)));
       this.a=Math.cos(Math.toRadians(degree));
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}

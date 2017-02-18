package util;


/**
 * Write a description of class lottozahlen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class lottozahlen
{
    // instance variables - replace the example below with your own
    private int[] zahlen=new int[6];

    /**
     * Constructor for objects of class lottozahlen
     */
    public lottozahlen()
    {
       
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void sampleMethod()
    { System.out.println("\f");
       for(int i=0;i<zahlen.length;i++){
        int x=(int)(Math.random()*49+1);
        zahlen[i]=x;
       
        System.out.println(zahlen[i]);
        }
    }
}

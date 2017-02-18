package util;


/**
 * Write a description of class Bitwise here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bitwise
{
    /**
     * Constructor for objects of class Bitwise
     */
    public Bitwise()
    {

    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static int[] toByte(int x)
    {
       int maxi=(int)( Math.log(x)/Math.log(2));
       int[]zahl=new int[maxi+1];
       for(int i=0;i<zahl.length;i++){
        zahl[i]=0;
        }
     h:while(true){ 
         
        zahl[maxi]=1;
        x-=Math.pow(2,maxi);
        maxi=(int)( Math.log(x)/Math.log(2));
        if(x==0){break h;}
       } 
       return zahl;
    }
}

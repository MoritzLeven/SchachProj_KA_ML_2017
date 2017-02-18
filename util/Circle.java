package util;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;
/**
 * Write a description of class Circle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Circle
{
     public int y;
     public int x;
     public double r;
     public ArrayList<koor>points;
    /**
     * Constructor for objects of class Circle
     */
    public Circle(int x,int y,double r)
    {
       this.x=x;
       this.y=y;
       this.r=r;
    }
    public Circle(int x,int y,double r,ArrayList points)
    {
       this.x=x;
       this.y=y;
       this.r=r;
       this.points=points;
       for(int i=0;i<(Math.PI*2*r);i++){
        points.add(new koor(x+Math.cos(Math.toRadians((360/(Math.PI*2*r))*i))*r,y+Math.sin(Math.toRadians((360/(Math.PI*2*r))*i))*r));
        }
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */

    public void draw(Graphics g){
      g.setColor(Color.BLACK);  
      for(int i=0;i<points.size();i++){
        g.fillRect((int)(points.get(i).getX()),(int)(points.get(i).getY()),1,1);
        }
    }
}

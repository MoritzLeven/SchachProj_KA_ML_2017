package util;

import java.awt.*;
import java.util.*;
/**
 * Write a description of class RQ here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RQ extends Rectangle
{
    ArrayList<Circle>points=new ArrayList<Circle>();
    
    /**
     * Constructor for objects of class RQ
     */
    public RQ(int x,int y,int width,int height)
    {
        this.x=x;this.y=y;this.width=width;this.height=height;
        for(int i=0;i<width;i++){Circle point=new Circle(x+i,y,0);points.add(point);}
        for(int i=0;i<height;i++){Circle point=new Circle(x,y+i,0);points.add(point);}
        for(int i=x;i<width+x;i++){Circle point=new Circle(i,y+height,0);points.add(point);}
        for(int i=y;i<height+y+1;i++){Circle point=new Circle(x+width,i,0);points.add(point);}
    }
  // void drawPoints(boolean clear){for(int i=0;i<points.size();i++){points.get(i).draw( }
   
   
}

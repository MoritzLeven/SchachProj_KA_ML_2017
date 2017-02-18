package util;

import java.util.ArrayList;
/**
 * Write a description of class gastebuch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gastebuch
{
    // instance variables - replace the example below with your own
    ArrayList<String>namen=new ArrayList<String>();
    ArrayList<String>komen=new ArrayList<String>();
    /**
     * Constructor for objects of class gastebuch
     */
    public gastebuch()
    {
        // initialise instance variables

    }
    public void hinz(String name,String komment){namen.add(name);komen.add(komment);}
    public void ausg(){int x=namen.size();
     for(int i=0;i<x;i++){String n=namen.get(i);String k=komen.get(i);System.out.println(n+": "+k);}
    }
   
}

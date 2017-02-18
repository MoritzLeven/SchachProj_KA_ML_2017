package util.Geometrie;


/**
 * Write a description of class wurfel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class wurfel
{
    double kantenlange;
    double volumen;
    double a_oberflache;
    double oberflache;
    boolean[] init=new boolean[4];
    
    wurfel(double kantenlange,double volumen,double a_oberflache,double oberflache){
     for(int i=0;i<init.length;i++){}   
     if(kantenlange>0){this.kantenlange=kantenlange;}else{init[0]=true;}
    }
}

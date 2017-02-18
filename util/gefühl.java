package util;


/**
 * Write a description of class gefühl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gefühl
{
    String[] gefuhl=new String[7];
    
    public gefühl(){
     gefuhl[1]="traurig";
     gefuhl[2]="frohlich";
     gefuhl[3]="verargert";
     gefuhl[4]="verliebt";
     gefuhl[5]="gelangweilt";
     gefuhl[6]="normal";
    }
    public  void dubist(){
         int x=Rechner.zufallx(7);
         x=x-1;
         System.out.println("Du bist "+ gefuhl[x]);
    }
}

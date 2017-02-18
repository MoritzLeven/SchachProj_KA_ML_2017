package util;


/**
 * Write a description of class GAni here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GAni
{
   
  

   
   

    /**
     * A Method wich shows -\|/-
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void mWait(String beforeDoublePoint,int Long,int begin,int boost)
    {
      String pattern[]=new String[4];

      pattern[0]="\\";
      pattern[1]="|";
      pattern[2]="/";
      pattern[3]="-";
     
      for(int l=0;l<Long;l++){
      if(begin>=4){begin=begin%4;}
      Str.clear();
      System.out.println(beforeDoublePoint+":"+pattern[begin]);
      begin++;
      try {
				Thread.sleep(boost);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    }
   }
  }

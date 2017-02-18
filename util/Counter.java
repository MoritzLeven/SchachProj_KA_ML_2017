package util;


/**
 * Write a description of class Counter here.
 * 
 * @author (Moritz Leven) 
 * @version (1.3)
 */
public class Counter
{
   int Z1;
   int Z2;
   int Z3;
   boolean w;
   double y;
   String bz;
   public static void count(int B){
       
    for(int Z=0;Z<B;Z++){
           System.out.println(Z);
        }
    } 
   
   public static void multi(int M){
    
       for(int Z=2;Z<M;Z=Z*Z){
        System.out.println(Z);
        }
       
    } 
   public static void div(int d){
       int Z2=1;
    for(int Z=2;Z2<d;d=d/Z){
    System.out.println(d);}
    } 
   public Counter(String Bz){w=true;bz=Bz;}
   public void bzr(){double y=Double.parseDouble(bz);for(double i=0.0;i<y;){char []out=bz.toCharArray();
     while(w==true){for(int i2=0;i2<(out.length-1);i2++){if(out[i2]==1){out[i2]=0;w=false;}}}
     bz=new String(out);y=Double.parseDouble(bz);
     System.out.println(bz);
    }}
    
}

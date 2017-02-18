package util;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a description of class Str here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Str
{
    ArrayList<String>wort=new ArrayList<String>();
    private String x;
    char[] out;
    /**
     * Constructor for objects of class Str
     */
    public Str(String X,int s,boolean c)
    {
        if(c=true){Str.clear();}s=(s-1);x=X;try{
        out=x.toCharArray();System.out.println(out[s]);
    }catch(Exception ex){System.out.println("So viele Buchstaben gibt es nicht");}}
    public void aus(int s){s=(s-1);try{out=x.toCharArray();System.out.println(out[s]);}catch(Exception ex){System.out.println("So viele Buchstaben gibt es nicht");}}
    public void change(String X){x=X;}
    public static void str(String X,int s)
    {
        s=(s-1);char []out=X.toCharArray();System.out.println(out[s]);
    }
    public static void clear(){System.out.println("\f");}
//    public String[] satzerk(){int index=0;int index2=0;String[] re=new String[20];out=x.toCharArray();char[] word=new char[20];
//        for(int i=0;i<out.length-1;i++){if(out[i]!=' '){word[index++]=out[i];}else{
//                                           index=0;String s=new String(word);re[index2++]=s;for(int i2=0;i2<word.length-1;i2++){word[i2]=0;}       } }  return re;}
   public static int langw(String s){char out[]=s.toCharArray();int i=out.length;return i;
    
    }
   public static ArrayList<String> satzerk(String text){
     /** ArrayList<ArrayList>Worter=new ArrayList<ArrayList>();
      ArrayList<Character> Wort=new ArrayList<Character> ();
      ArrayList<String>re=new ArrayList<String>();
      char[] x=text.toCharArray();
      byte[] y=text.getBytes();
      String leer=" ";
      byte[] leertaste=leer.getBytes();
      for(int i=0;i<x.length;i++){
        if(y[i]==leertaste[0]){
            Worter.add(Wort);
            Wort=new ArrayList<Character>();
         }else{
            Wort.add(x[i]);
         }
         }
         Worter.add(Wort);
      for(int i=0;i<Worter.size();i++){
       char[] ingri=new char[Worter.get(i).size()];
       for(int k=0;k<Worter.get(i).size();k++){
         //ingri[k]=(char)(Worter.get(i).get(k));
         }
       re.add(new String(ingri));
         }
      return re;    */
       Scanner sc=new Scanner(text);
       ArrayList<String>re=new ArrayList<String>();
       while (sc.hasNext()){
           re.add(sc.next());
       }
       return re;
    }

    public static String castInt(int n){
        byte[]bytes={(byte)(n)};
        return new String(bytes);
    }

    public static String one(String[] old,boolean space){
        String re="";
        for(int i=0;i<old.length;i++){
            if(space){
                re+=" ";
                re+=old[i];
            }else if(!space){
                re+=old[i];
            }
        }
        return re;
    }

    public static String[] toStringArray(ArrayList a){
        String[]re=new String[a.toArray().length];
        for(int i=0;i<re.length;i++){
            re[i]=(String)(a.toArray()[i]);
        }
        return re;
    }

    public static String arrayToString(byte[]bytes){
        String[]words=new String[bytes.length];
        for (int i1 = 0, bytesLength = bytes.length; i1 < bytesLength; i1++) {
            byte i = bytes[i1];
            words[i1]=String.valueOf((int)i);
        }
        return "byte array "+bytes.toString()+" : ["+one(words,true)+"]";
    }

    public static String arrayToString(int[]bytes){
        String[]words=new String[bytes.length];
        for (int i1 = 0, bytesLength = bytes.length; i1 < bytesLength; i1++) {
            int i = bytes[i1];
            words[i1]=String.valueOf((int)i);
        }
        return "int array "+bytes.toString()+" : ["+one(words,true)+"]";
    }

    /** public static int[] toIntArray(ArrayList a){
         int[]re=new int[a.toArray().length];
         for(int i=0;i<re.length;i++){
             re[i]=(int)(a.toArray()[i]);
         }
         return re;
     } */

    public static String[] wish(String[] be){
        int[]rei=Rechner.wish(be.length);
        String[]re=new String[be.length];
        for(int i=0;i<be.length;i++){
            re[i]=be[rei[i]];
        }
        return re;
    }

    public static void removeAll(ArrayList a){
        int s=a.size();
        for (int i = 0; i < s; i++) {
            a.remove(0);
        }
    }

    public static void uber(ArrayList a,ArrayList b){
        int s=a.size();
        for (int i = 0; i < s; i++) {
            a.remove(0);
        }
        for(int i=0;i<b.size();i++){
            a.add(b.get(i));
        }
    }
    
    
    public static void main(String[] args){
        ArrayList<String>a=satzerk("200.55 100 30.24");
        for (String i:a){
            System.out.println(Double.parseDouble(i)+" "+a.size()+" "+i.toCharArray().length);
        }
    }
}

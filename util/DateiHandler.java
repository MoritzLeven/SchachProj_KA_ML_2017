package util;

import java.io.File;
import java.util.Formatter;
import java.io.FileNotFoundException;
import java.util.*;
public class DateiHandler{

	public static void generate(String name){

		File f = new File("C://test//"+name+".txt");
		
		if(!f.exists()){
			try{
			Formatter format = new Formatter("C://test//"+name+".txt");
			} catch(FileNotFoundException e){
			e.printStackTrace();
			}
		}

	}
    public static String[] read(String name,String zeile){
     Scanner s=null;
     String zeilen[]=new String[20];
    
     int index=0;
    
     File f=new File("C://test//"+name+".txt");
     try{
			s = new Scanner(f);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
	     if(s.hasNext())s.findInLine(zeile);	
       
       while(s.hasNext()){zeilen[index++]=s.nextLine();}
       s.close();
	  return zeilen;	
    }
  
}

package util;

/**
 * Created by Nutzer on 17.06.2016.
 */
public class TextWork {
    public static String formatSpace(String s){
        char[]chars=s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='#'){
                chars[i]=' ';
            }
        }
        return new String(chars);
    }

    public static String enformatSpace(String s){
        char[]chars=s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]==' '){
                chars[i]='#';
            }
        }
        return new String(chars);
    }
}

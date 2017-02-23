package util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.acos;
import static java.lang.Math.sin;

/**
 * Write a description of class Rechner here.
 * 
 * @author (ML) 
 * @version (1.4)
 */
public class Rechner
{
    public static final int lengthDay=355;
    public static final int shortsDay=172;
    public static final int dnDayOne = 80;
    public static final int dnDayTwo =266;
    public static final double Y=0.0000000000667384;
    public static final double rtwo=Math.sqrt(2);
    public static final double musiccons=1.059463094359295;



    public static int[] teilbr(int z,boolean out){int x=2;if(out)System.out.println("\f");int prim=0;int howmuch=0;int index=0;
        for(int i=z-1;i>x;x++)  {int y=z%x;if(y==0){if(out)System.out.println(""+x);prim=x;howmuch++;}}if (prim==0) {if(out)System.out.println(z + " ist eine Primzahl");}if(out)System.out.println(howmuch+" Teiler");
        int[] teiler=new int[howmuch];x=2;
        for(int i=z-1;i>x;x++)  {int y=z%x;if(y==0){teiler[index++]=x;}}
        return teiler;
    }

    public static int zufallx(int x){
        return (int)(Math.random() * x + 1);
    }

    public static int flat(int a){
        if (a<0)return 0;
        return a;
    }

    public static String jahr(long t,int timezone,boolean dSTEnabled){
        long whole_t=t;
        long daysSince1970=whole_t/86400000;
        int dow=(int)((daysSince1970-4)%7);                                                     //dow steht für day of the week

        String[] days={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

        int[]dSTDates=null;

        if(dSTEnabled){
            dSTDates=getDaylightSavingTimeDates(t);                                             //Hier wird der letzte Sonntag ihm März und im Oktober errechnet, um die Sommerzeit miteinkalkulieren zu können
        }

        long ms=t%1000;                                                                         //Nun werden alle Zeiangaben berechnet
        t/=1000;
        long s=t%60;
        t/=60;
        long min=t%60;
        t/=60;
        long h=t%24+timezone;
        t/=24;
        double rt=(double)t;
        int d=(int)(rt%365);
        rt/=365;
        int y=(int)(1970+rt);
        int da=d-((int)((rt-2)/4));
        int fd=y%4==0?29:28;                                                                    //Dabei wird auch das Schaltjahr berücksichtigt
        int month=1;
        if (da>=31){
            month++;
            da-=31;
            if(da>=fd){
                month++;
                da-=fd;
                if(da>=31 ){
                    month++;
                    da-=31;
                    if(da>=30 ){
                        month++;
                        da-=30;
                        if(da>=31 ){
                            month++;
                            da-=31;
                            if(da>=30 ){
                                month++;
                                da-=30;
                                if(da>=31 ){
                                    month++;
                                    da-=31;
                                    if(da>=31 ){
                                        month++;
                                        da-=31;
                                        if(da>=30 ){
                                            month++;
                                            da-=30;
                                            if(da>=31 ){
                                                month++;
                                                da-=31;
                                                if(da>=30 ){
                                                    month++;
                                                    da-=30;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if(dSTEnabled&&(month==3&&(da+1)==dSTDates[0]&&h>=2)||(month==3&&(da+1)>=dSTDates[0])||(month>3&&month<10)||(month==10&&(da+1)<dSTDates[1])||(month==10&&(da+1)==dSTDates[1]&&h<2)){
           h+=1;                                                                                    //Nun wird die Sommerzeit einkalkuliert, außer man befindet sich in einem Gebiet in dem es sie nicht gibt (z.B Russland)
        }
        return String.format("%02d:%02d:%04d:%02d:%02d:%02d:%03d",da+1,month,y,h,min,s,ms)+" It's "+days[dow];
    }

    public static int[] getDaylightSavingTimeDates(long t){
        int[]dates=new int[2];

        t/=86400000;
        double rt=(double)t;
        rt/=365;
        int year=(int)(1970+rt);
        int y=year-1970;
        int firstDayOfMarch=(int)((y-2)*365.25+730)+(year%4==0?60:59);
        long march25_millis=(long)(firstDayOfMarch)*86400000l+2073600000l;

        int dateM=25;

        long daysSince1970M=march25_millis/86400000;
    a:  for(long i=0;i<7;i++){
            long thisdaySince1970M=daysSince1970M+i;
            int dow=(int)((thisdaySince1970M+3)%7);

            if(dow==6){
                dateM=25+(int)i;
                break a;
            }
        }

        if(year%4!=0)dateM--;
        dates[0]=dateM;


        int firstDayOfOct=(int)((y-2)*365.25+730)+(year%4==0?274:273);
        long oct25_millis=(long)(firstDayOfOct)*86400000l+2073600000l;

        int dateO=25;

        long daysSince1970O=oct25_millis/86400000;
    g:  for(long i=0;i<7;i++){
            long thisdaySince1970O=daysSince1970O+i;
            int dow=(int)((thisdaySince1970O+3)%7);

            if(dow==6){
                dateO=25+(int)i;
                break g;
            }
        }

        if(year%4!=0)dateO--;
        dates[1]=dateO;

        return dates;
     }

    public static double abstand(int x1,int y1,int x2,int y2){
        int a=Math.abs(x1-x2);
        int b=Math.abs(y1-y2);
        return Math.sqrt(((a*a)+(b*b)));
    }

    public static boolean circle_intersects(Circle c1, Circle c2){
        double a=abstand(c1.x,c1.y,c2.x,c2.y);
        double r=c1.r+c2.r;
        return (a-r)<=0;
    }

    public static boolean bzufall(){
        return Rechner.zufallx(2)==1;
    }

    public static int[] wish(int length){
        int[] re=new int[length];

        for(int i=0;i<re.length;i++){
            if(i!=0)
                re[i]=isnt(re,length,i);else if(i==0)re[0]=zufallx(length)-1;
        }

        return re;
    }

    private static int isnt(int[] list,int max,int is){
        int w=zufallx(max)-1;
        boolean b=true;
        isn:for(int i=0;i<=is-1;i++){
            if(list[i]==w){b=false;break isn;}
        }
        if(b){
            return w;
        }else{
            return isnt(list,max,is);
        }
    }

    public static double skalarproduct(double x1,double y1,double x2,double y2){
        return x1*x2+y1*y2;
    }

    public static double sqrt(double a){
        return sin(acos((((a+1)/2)-1)/((a+1)/2)))*((a+1)/2);
    }

    public static int findNextDivisor(int whole,int get){
        int re=0;
        int[]divisors=teilbr(whole,false);
        if(divisors.length==0||get==0)return get;
        int ab=0;
        int index=0;
        for(int i=0;i<divisors.length;i++){
            if(i==0)ab=Math.abs(divisors[i]-get);
            else{
                int cab=Math.abs(divisors[i]-get);
                if(cab<ab){ab=cab;index=i;}
            }
        }
        return divisors[index];
    }

    public static int[] ordne(int[]zuvor){
        int[]re=new int[zuvor.length];
        for(int i=0;i<zuvor.length;i++){
            int zahl=0;
            int abstand=100000000;
            for(int k=i+1;k<zuvor.length;k++){
                if((zuvor[k]-zuvor[i])<=abstand){
                    zahl=zuvor[k];
                    abstand=zuvor[k]-zuvor[i];
                }
            }
            re[i]=zahl;
        }
        return re;
    }

    public static byte[] toByteArray(ArrayList a){
        byte[]re=new byte[a.toArray().length];
        for(int i=0;i<re.length;i++){
            re[i]=Byte.parseByte(a.toArray()[i].toString());
        }
        return re;
    }

    public static int round(double in){
        double nk=in%1;
        int re=(int)in;
        if (nk>=0.5)re+=1;

        return re;
    }

    public static int toRGB(int red,int gre,int blu){
        Color c=new Color(red,gre,blu);
        return c.getRGB();
    }
    public static int toRGB(int red,int gre,int blu,int alpha){
        Color c=new Color(red,gre,blu,alpha);
        return c.getRGB();
    }

    public static BufferedImage removeRGB(BufferedImage image,int red,int gre,int blu){
        int RGB=toRGB(red,gre,blu);
        BufferedImage re=image;
        for(int i=0;i<image.getWidth();i++){
            for (int k = 0; k < image.getHeight(); k++) {
                int tRGB=image.getRGB(i,k);
                if(tRGB==RGB){
                    re.setRGB(i,k,toRGB(255,255,255,0));
                }
            }
        }
        return re;
    }

    public static BufferedImage changeRGB(BufferedImage image,int RGB,int toRGB,Rectangle place){
        BufferedImage re=image;
        for(int i=0;i<place.width;i++){
            for(int k=0;k<place.height;k++){
                if (image.getRGB(place.x+i,place.y+k)==RGB)re.setRGB(place.x+i,place.y+k,toRGB);
            }
        }
        return re;
    }

    public static boolean[] inbits(int be){
        int length=(int)(Math.log(be)/Math.log(2))+(((Math.log(be)/Math.log(2))%1)>0?1:0);
        boolean[]re=new boolean[length];
        for(int i=length-1;i>0;i--){
            re[i]=(be-Math.pow(2,i)<0?false:true);
            if(re[i])be-=(int)(Math.pow(2,i));
            //System.out.println(re[i]+" "+be+" "+i);
        }
        re[0]=(be-1<0?false:true);
        if(re[0])be-=1;
        //System.out.println(re[0]+" "+be+" "+0);
        return re;
    }

    public static int negate(int z,int rad){
        if(z==0)return 0;
        else{
            return(rad-z);
        }
    }

    public static boolean zwischen(int x,int min,int max){
        return x<=max&&x>=min;
    }

    public static void circle_collision(AdvCircle c1, AdvCircle c2,double epsilon){
        double normalx = c2.x - c1.x;
        double normaly = c2.y - c1.y;
        double length = Math.sqrt(normalx*normalx + normaly*normaly);
        normalx /= length;
        normaly /= length;

        double overlapplength = c2.radius + c1.radius - length;
        double masses = c1.mass + c2.mass;
        c1.x += -normalx * overlapplength * c2.mass / masses;
        c1.y += -normaly * overlapplength * c2.mass / masses;
        c2.x += +normalx * overlapplength * c1.mass / masses;
        c2.y += +normaly * overlapplength * c1.mass / masses;


        double f = (-(1+epsilon)*((c2.speedx - c1.speedx)*normalx + (c2.speedy-c1.speedy)*normaly))/(1/c1.mass + 1/c2.mass);

        double oldspeedxc1 = c1.speedx;
        double oldspeedyc1 = c1.speedy;
        double oldspeedxc2 = c2.speedx;
        double oldspeedyc2 = c2.speedy;

        c1.speedx = oldspeedxc1 - f/c1.mass * normalx;
        c1.speedy = oldspeedyc1 - f/c1.mass * normaly;

        c2.speedx = oldspeedxc2 + f/c2.mass * normalx;
        c2.speedy = oldspeedyc2 + f/c2.mass * normaly;
    }

    public static int[] toIntArray(ArrayList<Integer>ints){
        int[]re=new int[ints.size()];
        for (int i = 0; i < ints.size(); i++) {
            re[i]=ints.get(i);
        }
        return re;
    }

    public static void main(String[] args){
        System.out.println(36/8*8);

        System.out.println(jahr(System.currentTimeMillis(),1,true));
        //functionBuilder();
    }

    public static void functionBuilder(){
        Scanner sc=new Scanner(System.in);
        int grad=sc.nextInt();
        double[]nullstellenFaktoren=new double[grad];
        double[]koeffizienten=new double[grad+1];
        for (int i = 0; i < grad; i++) {
            System.out.print("Nullstelle " + (i + 1) + ": ");
            nullstellenFaktoren[i]=sc.nextDouble()*-1;
            System.out.print("\n");
        }
        /**Debug
        System.out.println("Nullstellen-Faktoren");
        for (int i = 0; i < nullstellenFaktoren.length; i++) {
            System.out.println(nullstellenFaktoren[i]);
        }
        *///Debug-Ende
        for (int i = 0; i <= Math.pow(2, grad)-1; i++) {
            double koeffizient=1;
            boolean[]isNeeded=integerToBytes(i);
            /**Debug
            String o="";
            for (int l = 0; l < isNeeded.length; l++) {
                if (isNeeded[l])
                    o+="1";
                else
                    o+="0";
            }
            System.out.println(o);
            *///Debug-Ende
            /**Debug
            System.out.println("Bits: "+Integer.toBinaryString(i)+" "+Integer.bitCount(i)+" "+isNeeded.length);
            *///Debug-Ende
            for (int k = 0; k < isNeeded.length; k++) {
                if(isNeeded[k])
                koeffizient*=nullstellenFaktoren[k];
            }
            koeffizienten[grad-Integer.bitCount(i)]+=koeffizient;
            //debug
            //System.out.println("["+(grad-Integer.bitCount(i))+"]+="+koeffizient);
        }
        String out="";
        for (int i = 0; i < koeffizienten.length; i++) {
            if((i>0)&&(koeffizienten[koeffizienten.length-i-1]>0)){
                out+="+";
            }
            if (koeffizienten[koeffizienten.length-i-1]!=0)
            out+=""+koeffizienten[koeffizienten.length-i-1]+"x^"+(grad-i);
        }
        System.out.println(out);
    }

    public static boolean[] integerToBytes(int z){
        /** int byte_seq=Integer.parseInt(Integer.toBinaryString(z));
         String formatter="";
         for (int i = 0; i < length; i++) {
             formatter+="0";
         }
         formatter+="%s";
         String bytesCaster=String.format(formatter,byte_seq);
         char[] bytes=bytesCaster.toCharArray(); */
        char[]bytes=Integer.toBinaryString(z).toCharArray();
        boolean[]re=new boolean[bytes.length];

        for (int i = 0; i < bytes.length; i++) {
            re[i]=(bytes[bytes.length-i-1]=='1');
        }
        return re;
    }


}

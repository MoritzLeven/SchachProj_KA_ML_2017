package util;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;


/**
 * Created by Admin on 24.10.2014.
 */
public class AdvImage {
    public  BufferedImage foundation;

    double degree=0;
    double scalex=1,scaley=1;
    int anchx=0,anchy=0;

    public AdvImage(BufferedImage foundation,double degree,double scalex,double scaley){
        this.foundation=foundation;
        this.degree=degree;
        this.scalex=scalex;
        this.scaley=scaley;
    }

    public AdvImage(BufferedImage foundation,double degree,double scalex,double scaley,int anchx,int anchy){
        this.foundation=foundation;
        this.degree=degree;
        this.scalex=scalex;
        this.scaley=scaley;
        this.anchx=anchx;
        this.anchy=anchy;
    }

    public AdvImage(BufferedImage foundation){
        this.foundation=foundation;
    }



    public AdvImage(BufferedImage foundation,int anchx,int anchy){
        this.foundation=foundation;
        this.anchx=anchx;
        this.anchy=anchy;
    }

    public AdvImage(BufferedImage foundation,double degree,int anchx,int anchy){
        this.foundation=foundation;
        this.anchx=anchx;
        this.anchy=anchy;
        this.degree=degree;
    }

    public void setDegree(double ndegree){
        degree=ndegree%360;
    }

    public double getDegree(){
        return degree;
    }

    public void setZoom(double zoom){
        this.scalex=zoom;
        this.scaley=zoom;
    }

    public int getWidth(){
        AffineTransform test=AffineTransform.getTranslateInstance(0,0);
        test.rotate(Math.toRadians(degree),anchx,anchy);
        double mscx=test.getScaleX();

        return (int)(foundation.getWidth() *scalex*mscx);

    }

    public int getHeight(){
        AffineTransform test=AffineTransform.getTranslateInstance(0,0);
        test.rotate(Math.toRadians(degree),anchx,anchy);

        double mscy=test.getScaleY();
        return (int)(foundation.getHeight() *scaley*mscy);

    }

    public double getScalex(){
        return scalex;
    }

    public double getScaley(){
        return scaley;
    }

    public void draw(Graphics g,int x,int y,boolean renderpos){

        AffineTransform at;
        if(!renderpos){
           at=AffineTransform.getTranslateInstance(x,y);
        }else{
           AffineTransform test=AffineTransform.getTranslateInstance(x,y);
            test.rotate(Math.toRadians(degree),anchx,anchy);
            double mscx=test.getScaleX();
            double mscy=test.getScaleY();
            x=Rechner.round(x-foundation.getWidth() *scalex*mscx/2);
            y=Rechner.round(y-foundation.getHeight()*scaley*mscy/2);

           at=AffineTransform.getTranslateInstance(x,y) ;
        }

        at.rotate(Math.toRadians(degree),anchx,anchy);
        at.scale(scalex,scaley);



        Graphics2D g2d=(Graphics2D)g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawImage(foundation,at,null);

    }

    public void draw(Graphics g,int x,int y,boolean renderpos,double dirx,double diry){

        AffineTransform at;
        if(!renderpos){
            at=AffineTransform.getTranslateInstance(x,y);
        }else{
            AffineTransform test=AffineTransform.getTranslateInstance(x,y);
            test.rotate(Math.toRadians(degree),anchx,anchy);
            double mscx=test.getScaleX();
            double mscy=test.getScaleY();
            x=Rechner.round(x-foundation.getWidth() *scalex*mscx/2);
            y=Rechner.round(y-foundation.getHeight()*scaley*mscy/2);

            at=AffineTransform.getTranslateInstance(x,y) ;
        }

        at.rotate(dirx,diry,anchx,anchy);
        at.scale(scalex,scaley);



        Graphics2D g2d=(Graphics2D)g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawImage(foundation,at,null);
    }

    public void draw(Graphics g,int x,int y,boolean renderpos,double dirx,double diry,double ar,double ag,double ab){
        BufferedImage toDraw=new BufferedImage(foundation.getWidth(),foundation.getHeight(),BufferedImage.TYPE_INT_ARGB);
        for(int i=0;i<foundation.getWidth();i++){
            for (int k = 0; k < foundation.getHeight(); k++) {
                Color crgb=new Color(foundation.getRGB(i, k));
                int nr=crgb.getRed();
                int ng=crgb.getGreen();
                int nb=crgb.getBlue();
                int na=crgb.getAlpha();

                System.out.println("At X:"+i+" Y:"+k+" R:"+nr+" G:"+ng+" B:"+nb);

                nr=(int)(nr*ar);
                ng=(int)(ng*ag);
                nb=(int)(nb*ab);



                toDraw.setRGB(i, k, new Color(nr, ng, nb,na).getRGB());
            }
        }
        AffineTransform at;
        if(!renderpos){
            at=AffineTransform.getTranslateInstance(x,y);
        }else{
            AffineTransform test=AffineTransform.getTranslateInstance(x,y);
            test.rotate(Math.toRadians(degree),anchx,anchy);
            double mscx=test.getScaleX();
            double mscy=test.getScaleY();
            x=Rechner.round(x-foundation.getWidth() *scalex*mscx/2);
            y=Rechner.round(y-foundation.getHeight()*scaley*mscy/2);

            at=AffineTransform.getTranslateInstance(x,y) ;
        }

        at.rotate(dirx,diry,anchx,anchy);
        at.scale(scalex,scaley);



        Graphics2D g2d=(Graphics2D)g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawImage(toDraw,at,null);
    }


}

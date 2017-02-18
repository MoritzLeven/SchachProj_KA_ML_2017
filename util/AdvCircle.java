package util;

/**
 * Created by Admin on 09.04.2015.
 */
public class AdvCircle {
    public double x;
    public double y;
    public double radius;

    public double mass = 1;
    public double speedx = 0;
    public double speedy = 0;

    public AdvCircle(int x, int y, double radius, double mass, double speedx, double speedy){
        this.x=x;
        this.y=y;
        this.radius=radius;
        this.mass=mass;
        this.speedx=speedx;
        this.speedy=speedy;
    }
}

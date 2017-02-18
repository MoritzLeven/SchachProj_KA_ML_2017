package util;


/**
 * Write a description of interface TIME here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface TIME
{
    float k_ms=1;
    float k_s=k_ms*1000;
    float k_min=k_s*60;
    float k_h=k_min*60;
    float k_d=k_h*24;
    float k_monat=k_d*30.4375f;
    float k_jahr=k_monat*12;
    
}

package util;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.image.BufferStrategy;

import java.awt.event.KeyEvent;
/**
 * Write a description of class Frame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Frame extends JFrame
{
   
    private BufferStrategy strat;
    ArrayList<koor>points=new ArrayList<koor>();
    Circle c;
   public Frame(int radius){
        c=new Circle(400,400,radius,points);
        addKeyListener(new Keyboard());
        setLayout(null);                                                                
		setSize(800,800);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		makeStrat();
		requestFocus();
		while(true){redraw();try{Thread.sleep(15);}catch(InterruptedException ex){}}
	}
	
	
	
	public void makeStrat() {
		createBufferStrategy(2);
		strat = getBufferStrategy();
	}
	
	
	public void redraw() {
		Graphics g = strat.getDrawGraphics();
		draw(g);
		g.dispose();
		strat.show();
	}

	private void draw(Graphics g) {
	  clear(g);	 
	  c.draw(g);
	  if(Keyboard.isKeyDown(KeyEvent.VK_ESCAPE))System.exit(0);
	}
	
	public void clear(Graphics g) {
	   g.setColor(getBackground());
	   g.fillRect(0,0,getWidth(),getHeight());
	   }
	//You have to hide you better!!
}
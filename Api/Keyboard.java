package Api;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{
	private static boolean[] keys = new boolean[1024];
	public static int getter=0;
	public static boolean isKeyDown(int keyCode){
		if(keyCode>=0&&keyCode<keys.length) return keys[keyCode];
		else return false;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		getter=keyCode;
		if(keyCode>=0&&keyCode<keys.length) keys[keyCode]=true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		getter=keyCode;
		if(keyCode>=0&&keyCode<keys.length) keys[keyCode]=false;
	}

// 	public  int getKey(){
//       for(int i=0;i<keys.length;i++){
//         if(keys[i]){getter=i;return getter;}
//         }
//         return getter;
//     }
	
	
	
	//Unnötig
	@Override
	public void keyTyped(KeyEvent arg0) {}

}

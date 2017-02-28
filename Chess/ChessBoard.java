package Chess;

/**
 * Created by Moritz Leven on 19.02.2017.
 */
import javax.swing.*;
import java.awt.*;

public class ChessBoard {


    //char[] xLetters = {'A','B','C','D','E','F','G','H'};
    //int[] yNumbers = {1,2,3,4,5,6,7,8};

    JFrame frame;
    JPanel Field[][] = new JPanel[8][8];

    Color white=new Color(255, 225, 163);
    Color black=new Color(75,37,5);

    Main m;

    public ChessBoard(Main main) {
        frame = new JFrame("Schachbrett");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(8, 8));

        m=main;


        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Field[x][y] = new JPanel();

                if ((x + y) % 2 == 0) {
                    Field[x][y].setBackground(white);
                } else {
                    Field[x][y].setBackground(black);

                }
                frame.add(Field[x][y]);

            }
        }
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    //run method is redundant, while ChessBoard is operated from the main-class

    //redraw method must be used after every move, or if the window is moved.
    public void redraw(){
        for (int i = 0; i < Field.length; i++) {
            for (int k = 0; k < Field[i].length; k++) {
                Graphics g=Field[i][k].getGraphics();
                g.setColor(Field[i][k].getBackground());
                g.fillRect(0,0,64,64);
            }
        }

        for (int i = 0; i < m.pieces.size(); i++) {
            int pos=m.pieces.get(i).pos;
            int y=pos/8;
            int x=pos-y*8;
            Field[x][y].getGraphics().drawImage(m.pieces.get(i).getImage(),1,1,null);
        }
    }
}

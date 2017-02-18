package GUI;

import javax.swing.*;
import java.awt.*;

public class ChessBoard {

    char[] xLetters = {'A','B','C','D','E','F','G','H'};
    int[] yNumbers = {1,2,3,4,5,6,7,8};

    JFrame frame;
    JPanel Field[][] = new JPanel[8][8];

    public ChessBoard() {
        frame = new JFrame("Schachbrett");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(8, 8));


        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Field[x][y] = new JPanel();

                if ((x + y) % 2 == 0) {
                    Field[x][y].setBackground(new Color(255, 208, 122));
                } else {
                    Field[x][y].setBackground(new Color(75,37,5));
                }
                frame.add(Field[x][y]);

            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new ChessBoard();
    }
}
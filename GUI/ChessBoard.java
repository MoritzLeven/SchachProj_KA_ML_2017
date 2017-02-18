package GUI;

import javax.swing.*;
import java.awt.*;

public class ChessBoard {

    JFrame frame;
    JPanel Field[][] = new JPanel[8][8];

    public ChessBoard() {
        frame = new JFrame("Schachbrett");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(8, 8));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Field[i][j] = new JPanel();

                if ((i + j) % 2 == 0) {
                    Field[i][j].setBackground(new Color(75,37,5));
                } else {
                    Field[i][j].setBackground(new Color(255, 208, 122));
                }
                frame.add(Field[i][j]);

            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ChessBoard();
    }
}
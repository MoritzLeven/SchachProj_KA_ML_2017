package GUI;

import Chess.Pawn;
import Chess.Piece;

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
                    Field[x][y].setBackground(new Color(255, 225, 163));
                } else {
                    Field[x][y].setBackground(new Color(75,37,5));

                }
                frame.add(Field[x][y]);

            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public void SetPiecePos(Piece character, int pos){
        int y=pos/8;
        int x=pos-y*8;

        Field[x][y].getGraphics().drawImage(character.getImage(),1,1,null);
    }

    public static void main(String[] args) {
        new ChessBoard();
        ChessBoard obj = new ChessBoard();
        obj.run();
    }

    public void run(){
        Pawn test = new Pawn(true,36,1,1);
        SetPiecePos(test,36);
    }




    public void reset(){

    }
}
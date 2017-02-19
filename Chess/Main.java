package Chess;

import java.util.ArrayList;

/**
 * Created by Moritz Leven on 04.02.2017.
 */
public class Main {
    ArrayList<Piece>pieces=new ArrayList<Piece>();

    ChessBoard cb;

    public Main(){
        cb=new ChessBoard(this);
        pieces.add(new Pawn(true,36,0,0));
        cb.redraw();
    }

    public static void main(String[] args){
        Main m=new Main();
    }
}

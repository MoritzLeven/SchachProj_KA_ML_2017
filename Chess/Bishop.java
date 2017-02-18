package Chess;

import java.util.ArrayList;

/**
 * Created by Admin on 18.02.2017.
 */
public class Bishop extends Piece {
    private static final int[] MP_W_ULBR={48,32,16, 0, 2, 4, 6};
    private static final int[] MP_W_BRUL={57,59,61,63,47,31,15};



    public Bishop(boolean white, int pos, int index, int indexIT) {
        super(white, pos, index, indexIT);
        setType(3);
    }

    @Override
    public ArrayList<Integer> possibleMoves(CField f) {
        //finding the maxpos for all corners
        int
    }

    @Override
    public ArrayList<Piece> shielding(CField f) {
        return null;
    }

    @Override
    public ArrayList<Piece> attacking(CField f) {
        return null;
    }

    //methods for the MaxPoses
    private int[] findMPs(){
        int y=pos/16;
        int x=pos-y*8;

        int[] re=new int[4];
        //calculating the maxposes in the order UL,BR,BL,UR
        int rex0=(y-x);
        if (rex0<0)rex0=0;
        int rey0
    }
}

package Chess;

import java.util.ArrayList;

/**
 * Created by Admin on 03.03.2017.
 */
public class King extends Piece {
    public King(boolean white, int pos, int index, int indexIT) {
        super(white, pos, index, indexIT);
        setType(5);
    }

    @Override
    public ArrayList<Integer> possibleMoves(CField f) {
        return null;
    }

    @Override
    public ArrayList<Piece> shielding(CField f) {
        return null;
    }

    @Override
    public ArrayList<Piece> attacking(CField f) {
        return null;
    }
}

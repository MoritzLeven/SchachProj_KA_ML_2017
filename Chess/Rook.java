package Chess;

import java.util.ArrayList;

/**
 * Created by Admin on 23.02.2017.
 */
public class Rook extends Piece {
    public Rook(boolean white, int pos, int index, int indexIT) {
        super(white, pos, index, indexIT);
        setType(1);
    }

    @Override
    public ArrayList<Integer> possibleMoves(CField f) {
        ArrayList<Integer>re=new ArrayList<Integer>();
        //calculating the moves for all directions in order L,R,U,D
        for (int i = pos; i > pos/8*8-1; i--) {
            Piece poo=f.getPieceByPos(i);
            if(poo==null){
                re.add(i);
            }else{
                if (poo.white!=white){
                    re.add(i);
                }
                break;
            }
        }
        for (int i = pos; i < pos/8*8+9; i++) {
            Piece poo=f.getPieceByPos(i);
            if(poo==null){
                re.add(i);
            }else{
                if (poo.white!=white){
                    re.add(i);
                }
                break;
            }
        }
        for (int i = pos; i > pos%8-1; i-=8) {
            Piece poo=f.getPieceByPos(i);
            if(poo==null){
                re.add(i);
            }else{
                if (poo.white!=white){
                    re.add(i);
                }
                break;
            }
        }
        for (int i = pos; i < pos%8+57; i+=8) {
            Piece poo=f.getPieceByPos(i);
            if(poo==null){
                re.add(i);
            }else{
                if (poo.white!=white){
                    re.add(i);
                }
                break;
            }
        }
        return re;
    }

    @Override
    public ArrayList<Piece> shielding(CField f) {
        ArrayList<Piece>re=new ArrayList<Piece>();
        //calculating the moves for all directions in order L,R,U,D
        for (int i = pos; i > pos/8*8-1; i--) {
            Piece poo=f.getPieceByPos(i);
            if(poo!=null){
                if (poo.white==white){
                    re.add(poo);
                }
                break;
            }
        }
        for (int i = pos; i < pos/8*8+9; i++) {
            Piece poo=f.getPieceByPos(i);
            if(poo!=null){
                if (poo.white==white){
                    re.add(poo);
                }
                break;
            }
        }
        for (int i = pos; i > pos%8-1; i-=8) {
            Piece poo=f.getPieceByPos(i);
            if(poo!=null){
                if (poo.white==white){
                    re.add(poo);
                }
                break;
            }
        }
        for (int i = pos; i < pos%8+57; i+=8) {
            Piece poo=f.getPieceByPos(i);
            if(poo!=null){
                if (poo.white==white){
                    re.add(poo);
                }
                break;
            }
        }
        return re;
    }

    @Override
    public ArrayList<Piece> attacking(CField f) {
        ArrayList<Piece>re=new ArrayList<Piece>();
        //calculating the moves for all directions in order L,R,U,D
        for (int i = pos; i > pos/8*8-1; i--) {
            Piece poo=f.getPieceByPos(i);
            if(poo!=null){
                if (poo.white!=white){
                    re.add(poo);
                }
                break;
            }
        }
        for (int i = pos; i < pos/8*8+9; i++) {
            Piece poo=f.getPieceByPos(i);
            if(poo!=null){
                if (poo.white!=white){
                    re.add(poo);
                }
                break;
            }
        }
        for (int i = pos; i > pos%8-1; i-=8) {
            Piece poo=f.getPieceByPos(i);
            if(poo!=null){
                if (poo.white!=white){
                    re.add(poo);
                }
                break;
            }
        }
        for (int i = pos; i < pos%8+57; i+=8) {
            Piece poo=f.getPieceByPos(i);
            if(poo!=null){
                if (poo.white!=white){
                    re.add(poo);
                }
                break;
            }
        }
        return re;
    }
}

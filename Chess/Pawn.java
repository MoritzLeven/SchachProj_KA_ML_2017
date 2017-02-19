package Chess;

import java.util.ArrayList;

/**
 * Created by Moritz Leven on 04.02.2017.
 */
public class Pawn extends Piece {

    boolean starting_pos;


    public Pawn(boolean white, int pos, int index, int indexIT) {
        super(white, pos, index, indexIT);
        setType(0);
    }



    public ArrayList<Integer> possibleMoves(CField f) {
        ArrayList<Integer>re=new ArrayList<Integer>();
        if(white){
            //simple forward movement
            if(pos>7&&!f.occupied(pos-8)){
                re.add(pos-8);
            }

            //double-forward from startpos
            if(starting_pos&&!f.occupied(pos-16)&&!f.occupied(pos-8)){
                re.add(pos-16);
            }

            //capturing the front-left piece
            if((pos%8)!=0) {
                Piece pal = f.getPieceByPos(pos-9);
                if ((pal!=null)&&(!pal.white)){
                    re.add(pos-9);
                }
            }

            //capturing the front-right piece
            if (((pos+1)%8)!=0){
                Piece par = f.getPieceByPos(pos-7);
                if ((par!=null)&&(!par.white)){
                    re.add(pos-7);
                }
            }
        }else{
            //simple forward movement
            if(pos<56&&!f.occupied(pos+8)){
                re.add(pos+8);
            }

            //double forward-movement from startpos
            if(starting_pos&&!f.occupied(pos+8)&&!f.occupied(pos+16)){
                re.add(pos+16);
            }

            //capturing the bottom-left piece
            if (((pos+1)%8)!=0){
                Piece par = f.getPieceByPos(pos+9);
                if ((par!=null)&&(par.white)){
                    re.add(pos+9);
                }
            }

            //capturing the bottom-right piece
            if((pos%8)!=0) {
                Piece pal = f.getPieceByPos(pos+7);
                if ((pal!=null)&&(pal.white)){
                    re.add(pos+7);
                }
            }
        }
        return re;
    }

    @Override
    public ArrayList<Piece> shielding(CField f) {
        ArrayList<Piece>re=new ArrayList<Piece>();
        if(white){
            //shielding the front-left piece
            if((pos%8)!=0) {
                Piece poo = f.getPieceByPos(pos-9);
                if ((poo!=null)&&(poo.white)){
                    re.add(poo);
                }
            }

            //shileding the front-right piece
            if (((pos+1)%8)!=0){
                Piece poo = f.getPieceByPos(pos-7);
                if ((poo!=null)&&(poo.white)){
                    re.add(poo);
                }
            }
        }else{
            //shielding the bottom-left piece
            if (((pos+1)%8)!=0){
                Piece poo = f.getPieceByPos(pos+9);
                if ((poo!=null)&&(!poo.white)){
                    re.add(poo);
                }
            }

            //shielding the bottom-right piece
            if((pos%8)!=0) {
                Piece poo = f.getPieceByPos(pos+7);
                if ((poo!=null)&&(!poo.white)){
                    re.add(poo);
                }
            }
        }
        return re;
    }

    @Override
    public ArrayList<Piece> attacking(CField f) {
        ArrayList<Piece>re=new ArrayList<Piece>();
        if(white){
            //attacking the front-left piece
            if((pos%8)!=0) {
                Piece poo = f.getPieceByPos(pos-9);
                if ((poo!=null)&&(!poo.white)){
                    re.add(poo);
                }
            }

            //attacking the front-right piece
            if (((pos+1)%8)!=0){
                Piece poo = f.getPieceByPos(pos-7);
                if ((poo!=null)&&(!poo.white)){
                    re.add(poo);
                }
            }
        }else{
            //attacking the bottom-left piece
            if (((pos+1)%8)!=0){
                Piece poo = f.getPieceByPos(pos+9);
                if ((poo!=null)&&(poo.white)){
                    re.add(poo);
                }
            }

            //attacking the bottom-right piece
            if((pos%8)!=0) {
                Piece poo = f.getPieceByPos(pos+7);
                if ((poo!=null)&&(poo.white)){
                    re.add(poo);
                }
            }
        }
        return re;
    }
}

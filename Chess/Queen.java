package Chess;

import java.util.ArrayList;

import static util.Rechner.flat;

/**
 * Created by Admin on 23.02.2017.
 */
public class Queen extends Piece {
    public Queen(boolean white, int pos, int index, int indexIT) {
        super(white, pos, index, indexIT);
        setType(4);
    }

    //first adding the methods of rook and bishop
    public ArrayList<Integer> rook_possibleMoves(CField f) {
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

    public ArrayList<Piece> rook_shielding(CField f) {
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

    public ArrayList<Piece> rook_attacking(CField f) {
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

    //methods of the bishop

    public ArrayList<Integer> bishop_possibleMoves(CField f) {
        ArrayList<Integer>re=new ArrayList<Integer>();
        //finding the maxpos for all corners
        int[] mps=findMPs();
        //calculating all possible moves in all directions in the order UL,BR,BL,UR
        for (int i = pos-9; i > mps[0]-1; i-=9) {
            Piece poo=f.getPieceByPos(i);
            if(poo==null){
                re.add(i);
            }else{
                if(poo.white!=white){
                    re.add(pos);
                }
                break;
            }
        }
        for (int i = pos+9; i < mps[0]+1; i+=9) {
            Piece poo=f.getPieceByPos(i);
            if(poo==null){
                re.add(i);
            }else{
                if(poo.white!=white){
                    re.add(pos);
                }
                break;
            }
        }
        for (int i = pos+7; i < mps[0]+1; i+=7) {
            Piece poo=f.getPieceByPos(i);
            if(poo==null){
                re.add(i);
            }else{
                if(poo.white!=white){
                    re.add(pos);
                }
                break;
            }
        }
        for (int i = pos-7; i > mps[0]-1; i-=7) {
            Piece poo=f.getPieceByPos(i);
            if(poo==null){
                re.add(i);
            }else{
                if(poo.white!=white){
                    re.add(pos);
                }
                break;
            }
        }
        return re;
    }

    public ArrayList<Piece> bishop_shielding(CField f) {
        ArrayList<Piece>re=new ArrayList<Piece>();
        //finding the maxpos for all corners
        int[] mps=findMPs();
        //calculating all possible moves in all directions in the order UL,BR,BL,UR
        for (int i = pos-9; i > mps[0]-1; i-=9) {
            Piece poo=f.getPieceByPos(i);
            if(poo!=null){
                if(poo.white==white){
                    re.add(poo);
                }
                break;
            }
        }
        for (int i = pos+9; i < mps[0]+1; i+=9) {
            Piece poo=f.getPieceByPos(i);
            if(poo!=null){
                if(poo.white==white){
                    re.add(poo);
                }
                break;
            }
        }
        for (int i = pos+7; i < mps[0]+1; i+=7) {
            Piece poo=f.getPieceByPos(i);
            if(poo!=null){
                if(poo.white==white){
                    re.add(poo);
                }
                break;
            }
        }
        for (int i = pos-7; i > mps[0]-1; i-=7) {
            Piece poo=f.getPieceByPos(i);
            if(poo!=null){
                if(poo.white==white){
                    re.add(poo);
                }
                break;
            }
        }
        return re;
    }

    public ArrayList<Piece> bishop_attacking(CField f) {
        ArrayList<Piece>re=new ArrayList<Piece>();
        //finding the maxpos for all corners
        int[] mps=findMPs();
        //calculating all possible moves in all directions in the order UL,BR,BL,UR
        for (int i = pos-9; i > mps[0]-1; i-=9) {
            Piece poo=f.getPieceByPos(i);
            if(poo!=null){
                if(poo.white!=white){
                    re.add(poo);
                }
                break;
            }
        }
        for (int i = pos+9; i < mps[0]+1; i+=9) {
            Piece poo=f.getPieceByPos(i);
            if(poo!=null){
                if(poo.white!=white){
                    re.add(poo);
                }
                break;
            }
        }
        for (int i = pos+7; i < mps[0]+1; i+=7) {
            Piece poo=f.getPieceByPos(i);
            if(poo!=null){
                if(poo.white!=white){
                    re.add(poo);
                }
                break;
            }
        }
        for (int i = pos-7; i > mps[0]-1; i-=7) {
            Piece poo=f.getPieceByPos(i);
            if(poo!=null){
                if(poo.white!=white){
                    re.add(poo);
                }
                break;
            }
        }
        return re;
    }

    //method for the MaxPoses
    private int[] findMPs(){
        int y=pos/16;
        int x=pos-y*8;

        int[] re=new int[4];
        //calculating the maxposes in the order UL,BR,BL,UR
        int rex0=flat(x-y);
        int rey0=flat(y-x);
        re[0]=rex0+rey0*8;

        int rex1=x+(7-y);
        if(rex1>7)rex1=7;
        int rey1=y+(7-x);
        if(rey1>7)rey1=7;
        re[1]=rex1+rey1*8;

        int rex2=x-(7-y);
        if(rex2<0)rex2=0;
        int rey2=y+x;
        if(rey2>7)rey2=7;
        re[2]=rex2+rey2*8;

        int rex3=x+y;
        if(rex3>7)rex3=7;
        int rey3=x-(7-y);
        if(rey3<0)rey3=0;
        re[3]=rex3+rey3*8;

        return re;
    }


    //Own methods

    @Override
    public ArrayList<Integer> possibleMoves(CField f) {
        ArrayList<Integer>re=new ArrayList<Integer>();
        re.addAll(rook_possibleMoves(f));
        re.addAll(bishop_possibleMoves(f));
        return re;
    }

    @Override
    public ArrayList<Piece> shielding(CField f) {
        ArrayList<Piece>re=new ArrayList<Piece>();
        re.addAll(rook_shielding(f));
        re.addAll(bishop_shielding(f));
        return re;
    }

    @Override
    public ArrayList<Piece> attacking(CField f) {
        ArrayList<Piece>re=new ArrayList<Piece>();
        re.addAll(rook_attacking(f));
        re.addAll(bishop_attacking(f));
        return re;
    }
}

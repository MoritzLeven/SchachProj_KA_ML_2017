package Chess;

import java.util.ArrayList;

/**
 * Created by Admin on 03.03.2017.
 */
public class Knight extends Piece {

    //All reachable positions
    int[] chPoses={-17,-15,-6,10,17,15,6,-10};

    public Knight(boolean white, int pos, int index, int indexIT) {
        super(white, pos, index, indexIT);
        setType(2);
    }

    @Override
    public ArrayList<Integer> possibleMoves(CField f) {
        ArrayList<Integer>re=new ArrayList<Integer>();
        //now checking all possible moves int the order UL,UR,RU,RB,BL,BR,LB,LU
        for (int i = 0; i < chPoses.length; i++) {
            int cpos=pos+chPoses[i];
            if(cpos>=0&&cpos<=63){
                Piece poo=f.getPieceByPos(cpos);
                if (poo==null){
                    re.add(cpos);
                }else{
                    if (poo.white!=white)re.add(cpos);
                }
            }
        }
        return re;
    }

    @Override
    public ArrayList<Piece> shielding(CField f) {
        ArrayList<Piece>re=new ArrayList<Piece>();
        //now checking all possible moves int the order UL,UR,RU,RB,BL,BR,LB,LU
        for (int i = 0; i < chPoses.length; i++) {
            int cpos=pos+chPoses[i];
            if(cpos>=0&&cpos<=63){
                Piece poo=f.getPieceByPos(cpos);
                if (poo!=null&&poo.white==white){
                    re.add(poo);
                }
            }
        }
        return re;
    }

    @Override
    public ArrayList<Piece> attacking(CField f) {
        ArrayList<Piece>re=new ArrayList<Piece>();
        //now checking all possible moves int the order UL,UR,RU,RB,BL,BR,LB,LU
        for (int i = 0; i < chPoses.length; i++) {
            int cpos=pos+chPoses[i];
            if(cpos>=0&&cpos<=63){
                Piece poo=f.getPieceByPos(cpos);
                if (poo!=null&&poo.white!=white){
                    re.add(poo);
                }
            }
        }
        attKing=re.contains(f.getKing(!white));
        return re;
    }
}

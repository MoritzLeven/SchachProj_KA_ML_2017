package Chess;

/**
 * Created by Moritz Leven on 04.02.2017.
 * Edited by HendrikRe on 18.02.2017.
 */
public class CField {

    Piece[]field;

    Piece[]whites;      //The white pieces
    Piece[]blacks;      //The balck pieces

    boolean[]nowhi;     //Indicates which white pieces are not anymore on the field
    boolean[]nobla;     //Indicates which black pieces are not anymore on the field

    public CField(){
        whites=new Piece[16];
        blacks=new Piece[16];

        nowhi=new boolean[16];
        nobla=new boolean[16];

        field=new Piece[64];

        for (int i = 0; i < 8; i++) {

        }
    }

    //Returns the type of the piece having the given index
    public int getTypeByIn(boolean white,int index){
        if(white){
            for (int i = 0; i < whites.length; i++) {
                if(whites[i].index==index){
                    return whites[i].type;
                }
            }
        }else{
            for (int i = 0; i < blacks.length; i++) {
                if(blacks[i].index==index){
                    return blacks[i].type;
                }
            }
        }
        return 0;
    }

    //Returns the piece on the given pos
    public Piece getPieceByPos(int pos){
        return field[pos];
    }

    //Returns true, if the given pos is occupied
    public boolean occupied(int pos){
        return field[pos]!=null;
    }

}

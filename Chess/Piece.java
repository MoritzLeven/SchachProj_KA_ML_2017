package Chess;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Moritz Leven on 04.02.2017.
 */
public abstract class Piece {
    boolean white;
    int type;   //0=pawn;1=rook;2=knight;3=bishop;4=queen;5=king;
    int pos;    //(#letter-1)+(number-1)*8
    int indexIT;//a var to differentiate between pieces of the same type
    int index;  //the index of the piece in the formation

    Image image;    //the corresponding image

    ArrayList<Integer>possibleMoves; //A list of all currently possible moves updated after every move;

    //Values of shielding/attacking a specific type ([0]=pawn;[1]=rook;[2]=knight;[3]=bishop;[4]=queen;[5]=king)
    public static final int[] VALUESOFSH={3,2,2,2,1,0};
    public static final int[] VALUESOFAT={0,2,2,2,1,5};

    public Piece(boolean white,int pos,int index,int indexIT){
        this.white=white;
        //type will be initialized here by further classes
        this.pos=pos;
        this.index=index;
        this.indexIT=indexIT;

        possibleMoves=new ArrayList<Integer>();
        image=null;
    }

    public void update(CField f){
        //possibleMoves=possibleMoves(f);
    }

    public void setType(int type){
        this.type=type;
        try {
            image= ImageIO.read(getClass().getClassLoader().getResourceAsStream("gfx/chess_piece_type_"+type+"_colourwhite="+white+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Image getImage(){
        return image;
    }

    //This method calculates all moves possible
    public abstract ArrayList<Integer> possibleMoves(CField f);

    //This method calculates all allied pieces shielded by this piece
    //For each reachable field occupied by any piece a Piece Of Observation (poo) will be created to compare colour and adding
    public abstract ArrayList<Piece> shielding(CField f);

    //This method calculates all enemy pieces, which can be attacked by this piece in the next move
    //For each attackable field occupied by any piece a Piece Of Observation (poo) will be created to compare colour and adding
    public abstract ArrayList<Piece> attacking(CField f);

    //This method calculates the value of the piece's current position
    public int valOfPos(CField f){
        ArrayList<Piece>sh=shielding(f);
        ArrayList<Piece>at=attacking(f);

        int val=0;
        for(int i=0;i<sh.size();i++){
            val+=VALUESOFSH[sh.get(i).type];
        }
        for(int i=0;i<at.size();i++){
            val+=VALUESOFAT[at.get(i).type];
        }

        return val;
    }

    public boolean equals(Piece p){
        return (p.white==white)&&(p.index==index);
    }

}

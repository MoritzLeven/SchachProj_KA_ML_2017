
---ONLINE CHESS---
Version from 18.02.2017
AUTHORS: MoritzLeven, HendrikRe, Klemens-And


                Information


A) Introduction and AI-mechanism

This is a simple form of an chess-computer, which works with a 5th degree forwardthinking.
That means it calculates 5 moves before it actualy moves. The move executed is determined by evaluating all end-of-tree moves
and choosing the best one by min-maxing.
For evaluating a combination of two techniques is use:
    1. For each piece it is calculated which pieces of the own are shielded and which pieces of the enemy are attacked.
       Those values are added together where the values of the enemy pieces are multiplied by -1.
    2. It is calculated which pieces are missing in comparison with the momantaneous state.
       The sum of those values is calculated where the own losses are multiplied with -1.

B) Representation of the field

The field positions are represented by a linear array:

       00 01 02 03 04 05 06 07
       08 09 10 11 12 13 14 15
       16 17 18 19 20 21 22 23
       24 25 26 27 28 29 30 31
       32 33 34 35 36 37 38 39
       40 41 42 43 44 45 46 47
       48 49 50 51 52 53 54 55
       56 57 58 59 60 61 62 63

The white pieces are starting at the bottom (positions 48-63) and the black at the top (positions 0-15).

In case the human player picks black the matrix is turned around for the drawing, so the pieces of the human player are always
at the bottom.
That means also that in case the local multiplayer is used the "board" is turned after every move.
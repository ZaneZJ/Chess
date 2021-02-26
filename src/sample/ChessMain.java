package sample;

public class ChessMain {

    /**
     *
     *  Chess pieces:
     *
     *  wK - white king
     *  wQ - white queen
     *  wR - white rook
     *  wB - white bishop
     *  wN - white knight
     *  wP - white pawn
     *
     *  bK - black king
     *  bQ - black queen
     *  bR - black rook
     *  bB - black bishop
     *  bN - black knight
     *  bP - black pawn
     *
     */

    public static void main(String[] args) {

        Game game = new Game();

        game.print();
        game.move();

    }

}

package sample;

public class Game {

    /**
     *
     *  Chess starting position
     *
     */

    public String[][] chessGrid = {
            { "wR", "wN", "wB", "wQ", "wK", "wB", "wN", "wR" },
            { "wP", "wP", "wP", "wP", "wP", "wP", "wP", "wP" },
            { "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  " },
            { "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  " },
            { "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  " },
            { "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  " },
            { "bP", "bP", "bP", "bP", "bP", "bP", "bP", "bP" },
            { "bR", "bN", "bB", "bQ", "bK", "bB", "bN", "bR" }
    };

    public int fromRow, fromCol, toRow, toCol;
    public boolean stopTheGame = false;
    public boolean white = true;
    public boolean black = false;

}

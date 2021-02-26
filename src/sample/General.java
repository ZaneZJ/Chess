package sample;

public class General {

    public static boolean isWhite(String piece) {

        Values values = new Values();

        if (piece.charAt(0) == values.WHITE) {
            return true;
        }
        return false;
    }

    public static boolean isBlack(String piece) {

        Values values = new Values();

        if (piece.charAt(0) == values.BLACK) {
            return true;
        }
        return false;
    }

    public static boolean isColor(String piece, char color) {

        Values values = new Values();

        if (color == values.WHITE) {
            return isWhite(piece);
        } else if (color == values.BLACK) {
            return isBlack(piece);
        }
        return false;
    }

    public char getPiece(String piece) {

        return piece.charAt(1);
    }

    public String createPiece(char color, char piece) {

        String colorStr = Character.toString(color);
        String pieceStr = Character.toString(piece);

        String newPiece = colorStr + pieceStr;

        return newPiece;
    }

    public void boardClear() {

        Game game = new Game();

        String[][] clearChessGrid = {
            { "wR", "wN", "wB", "wQ", "wK", "wB", "wN", "wR" },
            { "wP", "wP", "wP", "wP", "wP", "wP", "wP", "wP" },
            { "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  " },
            { "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  " },
            { "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  " },
            { "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  " },
            { "bP", "bP", "bP", "bP", "bP", "bP", "bP", "bP" },
            { "bR", "bN", "bB", "bQ", "bK", "bB", "bN", "bR" }
        };

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                game.chessGrid[i][j] = clearChessGrid[i][j];
            }
        }
    }

}

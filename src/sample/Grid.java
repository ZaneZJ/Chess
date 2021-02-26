package sample;

public class Grid {

    public static void grid(int fromRow, int fromCol, int toRow, int toCol) {

        General general = new General();
        Game game = new Game();
        Values values = new Values();
        Pieces pieces = new Pieces();

        char color = values.WHITE;
        if (game.black == true) {
            color = values.BLACK;
        }

        if (!general.isColor(game.chessGrid[fromRow][fromCol], color)) {
            System.out.println("You can't move enemies pieces!");
            return;
        }

        switch (general.getPiece(game.chessGrid[fromRow][fromCol])) {
            case 'B':
                pieces.moveBishop(color, fromRow, fromCol, toRow, toCol);
                break;
            case 'R':
                pieces.moveRook(color, fromRow, fromCol, toRow, toCol);
                break;
            case 'N':
                pieces.moveKnight(color, fromRow, fromCol, toRow, toCol);
                break;
            case 'Q':
                pieces.moveQueen(color, fromRow, fromCol, toRow, toCol);
                break;
            case 'K':
                pieces.moveKing(color, fromRow, fromCol, toRow, toCol);
                break;
            case 'P':
                pieces.movePawn(color, fromRow, fromCol, toRow, toCol);
                break;
            default:
                System.out.println("There is no piece there!");
        }
    }
}

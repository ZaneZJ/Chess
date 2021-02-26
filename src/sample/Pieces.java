package sample;

public class Pieces {

    /**
     *
     *  Bishop
     *
     */

    public static void moveBishop(char color, int fromRow, int fromCol, int toRow, int toCol) {

        General general = new General();
        Game game = new Game();
        Values values = new Values();

        if (general.isColor(game.chessGrid[toRow][toCol], color)) {
            System.out.println("You can't move on top on your own piece");
        } else {
            for (int changeI = -1; changeI <= 1; changeI += 2) {
                for (int changeJ = -1; changeJ <= 1; changeJ += 2) {
                    int col = fromCol + changeJ;
                    for (int row = fromRow + changeI; row < 8 && row >= 0; row += changeI) {
                        if (col < 8 && col >= 0) {
                            if (toRow == row && toCol == col) {
                                game.chessGrid[fromRow][fromCol] = values.EMPTY;
                                game.chessGrid[toRow][toCol] = general.createPiece(color, values.BISHOP);
                                game.black = color != values.BLACK;
                                game.white = color != values.WHITE;
                                return;
                            } else if (game.chessGrid[row][col] != values.EMPTY) {
                                break;
                            }
                            col += changeJ;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     *
     *  Rook
     *
     */

    public static void moveRook(char color, int fromRow, int fromCol, int toRow, int toCol) {

        General general = new General();
        Game game = new Game();
        Values values = new Values();

        if (general.isColor(game.chessGrid[toRow][toCol], color)) {
            System.out.println("You can't move on top on your own piece");
        } else {
            for (int changeI = -1; changeI <= 1; changeI += 2) {
                int col = fromCol;
                for (int row = fromRow + changeI; row < 8 && row >= 0; row += changeI) {
                    if (toRow == row && toCol == col) {
                        game.chessGrid[fromRow][fromCol] = values.EMPTY;
                        game.chessGrid[toRow][toCol] = general.createPiece(color, values.ROOK);
                        game.black = color != values.BLACK;
                        game.white = color != values.WHITE;
                        return;
                    } else if (game.chessGrid[row][col] != values.EMPTY) {
                        break;
                    }
                }
            }
            for (int changeJ = -1; changeJ <= 1; changeJ += 2) {
                int row = fromRow;
                for (int col = fromCol + changeJ; col < 8 && col >= 0; col += changeJ) {
                    if (toRow == row && toCol == col) {
                        game.chessGrid[fromRow][fromCol] = values.EMPTY;
                        game.chessGrid[toRow][toCol] = general.createPiece(color, values.ROOK);
                        game.black = color != values.BLACK;
                        game.white = color != values.WHITE;
                        return;
                    } else if (game.chessGrid[row][col] != values.EMPTY) {
                        break;
                    }
                }
            }
        }
    }

    /**
     *
     *  Queen
     *
     */

    public static void moveQueen(char color, int fromRow, int fromCol, int toRow, int toCol) {

        General general = new General();
        Game game = new Game();
        Values values = new Values();

        if (general.isColor(game.chessGrid[toRow][toCol], color)) {
            System.out.println("You can't move on top on your own piece");
        } else {
            for (int changeI = -1; changeI <= 1; changeI += 2) {
                for (int changeJ = -1; changeJ <= 1; changeJ += 2) {
                    int col = fromCol + changeJ;
                    for (int row = fromRow + changeI; row < 8 && row >= 0; row += changeI) {
                        if (col < 8 && col >= 0) {
                            if (toRow == row && toCol == col) {
                                game.chessGrid[fromRow][fromCol] = values.EMPTY;
                                game.chessGrid[toRow][toCol] = general.createPiece(color, values.QUEEN);
                                game.black = color != values.BLACK;
                                game.white = color != values.WHITE;
                                return;
                            } else if (game.chessGrid[row][col] != values.EMPTY) {
                                break;
                            }
                            col += changeJ;
                        } else {
                            break;
                        }
                    }
                }
            }
            for (int changeI = -1; changeI <= 1; changeI += 2) {
                int col = fromCol;
                for (int row = fromRow + changeI; row < 8 && row >= 0; row += changeI) {
                    if (toRow == row && toCol == col) {
                        game.chessGrid[fromRow][fromCol] = values.EMPTY;
                        game.chessGrid[toRow][toCol] = general.createPiece(color, values.QUEEN);
                        game.black = color != values.BLACK;
                        game.white = color != values.WHITE;
                        return;
                    } else if (game.chessGrid[row][col] != values.EMPTY) {
                        break;
                    }
                }
            }
            for (int changeJ = -1; changeJ <= 1; changeJ += 2) {
                int row = fromRow;
                for (int col = fromCol + changeJ; col < 8 && col >= 0; col += changeJ) {
                    if (toRow == row && toCol == col) {
                        game.chessGrid[fromRow][fromCol] = values.EMPTY;
                        game.chessGrid[toRow][toCol] = general.createPiece(color, values.QUEEN);
                        game.black = color != values.BLACK;
                        game.white = color != values.WHITE;
                        return;
                    } else if (game.chessGrid[row][col] != values.EMPTY) {
                        break;
                    }
                }
            }
        }
    }

    /**
     *
     *  King
     *
     */

    public static void moveKing(char color, int fromRow, int fromCol, int toRow, int toCol) {

        General general = new General();
        Game game = new Game();
        Values values = new Values();

        if (general.isColor(game.chessGrid[toRow][toCol], color)) {
            System.out.println("You can't move on top on your own piece");;
        } else {
            for (int changeI = -1; changeI <= 1; changeI += 2) {
                for (int changeJ = -1; changeJ <= 1; changeJ += 2) {
                    int col = fromCol + changeJ;
                    int row = fromRow + changeI;
                    if (col < 8 && col >= 0 && row < 8 && row >= 0) {
                        if ( toRow == row && toCol == col) {
                            game.chessGrid[fromRow][fromCol] = values.EMPTY;
                            game.chessGrid[toRow][toCol] = general.createPiece(color, values.KING);
                            game.black = color != values.BLACK;
                            game.white = color != values.WHITE;
                            return;
                        }
                    }
                }
            }
            for (int changeI = -1; changeI <= 1; changeI += 2) {
                int col = fromCol;
                int row = fromRow + changeI;
                if (row < 8 && row >= 0) {
                    if ( toRow == row && toCol == col) {
                        game.chessGrid[fromRow][fromCol] = values.EMPTY;
                        game.chessGrid[toRow][toCol] = general.createPiece(color, values.KING);
                        game.black = color != values.BLACK;
                        game.white = color != values.WHITE;
                        return;
                    }
                }
            }
            for (int changeJ = -1; changeJ <= 1; changeJ += 2) {
                int row = fromRow;
                int col = fromCol + changeJ;
                if (col < 8 && col >= 0) {
                    if ( toRow == row && toCol == col) {
                        game.chessGrid[fromRow][fromCol] = values.EMPTY;
                        game.chessGrid[toRow][toCol] = general.createPiece(color, values.KING);
                        game.black = color != values.BLACK;
                        game.white = color != values.WHITE;
                        return;
                    }
                }
            }
        }
    }

    /**
     *
     *  Knight
     *
     */

    public static void moveKnight(char color, int fromRow, int fromCol, int toRow, int toCol) {

        General general = new General();
        Game game = new Game();
        Values values = new Values();

        if (general.isColor(game.chessGrid[toRow][toCol], color)) {
            System.out.println("You can't move on top on your own piece");
        } else {
            for (int changeI = -1; changeI <= 1; changeI += 2) {
                for (int changeJ = -2; changeJ <= 2; changeJ += 4) {
                    int col = fromCol + changeJ;
                    for (int row = fromRow + changeI; row < 8 && row >= 0; row += changeI) {
                        if ( toRow == row && toCol == col) {
                            game.chessGrid[fromRow][fromCol] = values.EMPTY;
                            game.chessGrid[toRow][toCol] = general.createPiece(color, values.KNIGHT);
                            game.black = color != values.BLACK;
                            game.white = color != values.WHITE;
                            return;
                        }
                    }
                }
            }
            for (int changeJ = -1; changeJ <= 1; changeJ += 2) {
                for (int changeI = -2; changeI <= 2; changeI += 4) {
                    int row = fromRow + changeI;
                    for (int col = fromCol + changeJ; col < 8 && col >= 0; col += changeJ) {
                        if ( toRow == row && toCol == col) {
                            game.chessGrid[fromRow][fromCol] = values.EMPTY;
                            game.chessGrid[toRow][toCol] = general.createPiece(color, values.KNIGHT);
                            game.black = color != values.BLACK;
                            game.white = color != values.WHITE;
                            return;
                        }
                    }
                }
            }
        }
    }

    /**
     *
     *  Pawn
     *
     */

    public static void movePawn(char color, int fromRow, int fromCol, int toRow, int toCol) {

        General general = new General();
        Game game = new Game();
        Values values = new Values();

        if (color == values.WHITE) {
            if (fromRow == 1) {
                int col = fromCol;
                for (int row = fromRow + 1; row < 4; row++) {
                    if ( toRow == row && toCol == col && game.chessGrid[toRow][toCol] == values.EMPTY) {
                        game.chessGrid[fromRow][fromCol] = values.EMPTY;
                        game.chessGrid[toRow][toCol] = general.createPiece(color, values.PAWN);
                        game.black = color != values.BLACK;
                        game.white = color != values.WHITE;
                        return;
                    } else if (game.chessGrid[row][col] != values.EMPTY) {
                        break;
                    }
                }
            } else if (fromRow != 1) {
                int col = fromCol;
                int row = fromRow + 1;
                if ( toRow == row && toCol == col && game.chessGrid[toRow][toCol] == values.EMPTY) {
                    game.chessGrid[fromRow][fromCol] = values.EMPTY;
                    game.chessGrid[toRow][toCol] = general.createPiece(color, values.PAWN);
                    game.black = color != values.BLACK;
                    game.white = color != values.WHITE;
                    return;
                }
            }
            for (int changeJ = -1; changeJ <= 1; changeJ += 2) {
                int col = fromCol + changeJ;
                int row = fromRow + 1;
                if ( toRow == row && toCol == col && general.isBlack(game.chessGrid[toRow][toCol]) == true) {
                    game.chessGrid[fromRow][fromCol] = values.EMPTY;
                    game.chessGrid[toRow][toCol] = general.createPiece(color, values.PAWN);
                    game.black = color != values.BLACK;
                    game.white = color != values.WHITE;
                    return;
                }
            }
        } else if (color == values.BLACK) {
            if (fromRow == 6) {
                int col = fromCol;
                for (int row = fromRow - 1; row > 3; row--) {
                    if ( toRow == row && toCol == col && game.chessGrid[toRow][toCol] == values.EMPTY) {
                        game.chessGrid[fromRow][fromCol] = values.EMPTY;
                        game.chessGrid[toRow][toCol] = general.createPiece(color, values.PAWN);
                        game.black = color != values.BLACK;
                        game.white = color != values.WHITE;
                        return;
                    } else if (game.chessGrid[row][col] != values.EMPTY) {
                        break;
                    }
                }
            } else if (fromRow != 6) {
                int col = fromCol;
                int row = fromRow - 1;
                if ( toRow == row && toCol == col && game.chessGrid[toRow][toCol] == values.EMPTY) {
                    game.chessGrid[fromRow][fromCol] = values.EMPTY;
                    game.chessGrid[toRow][toCol] = general.createPiece(color, values.PAWN);
                    game.black = color != values.BLACK;
                    game.white = color != values.WHITE;
                    return;
                }
            }
            for (int changeJ = -1; changeJ <= 1; changeJ += 2) {
                int col = fromCol + changeJ;
                int row = fromRow - 1;
                if ( toRow == row && toCol == col && general.isWhite(game.chessGrid[toRow][toCol]) == true) {
                    game.chessGrid[fromRow][fromCol] = values.EMPTY;
                    game.chessGrid[toRow][toCol] = general.createPiece(color, values.PAWN);
                    game.black = color != values.BLACK;
                    game.white = color != values.WHITE;
                    return;
                }
            }

        }
    }

}

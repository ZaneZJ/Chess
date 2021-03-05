package sample;

public class Pieces {

    private Game game;
    
    public Pieces(Game game) {
        this.game = game;
    }

    public void grid(int fromRow, int fromCol, int toRow, int toCol) {

        if (!game.grid.isColor(game.grid.chessGrid[fromRow][fromCol], game.playerTurn)) {
            System.out.println("You can't move enemies pieces!");
            return;
        }

        switch (game.grid.getPiece(game.grid.chessGrid[fromRow][fromCol])) {
            case 'B':
                moveBishop(game.playerTurn, fromRow, fromCol, toRow, toCol);
                break;
            case 'R':
                moveRook(game.playerTurn, fromRow, fromCol, toRow, toCol);
                break;
            case 'N':
                moveKnight(game.playerTurn, fromRow, fromCol, toRow, toCol);
                break;
            case 'Q':
                moveQueen(game.playerTurn, fromRow, fromCol, toRow, toCol);
                break;
            case 'K':
                moveKing(game.playerTurn, fromRow, fromCol, toRow, toCol);
                break;
            case 'P':
                movePawn(game.playerTurn, fromRow, fromCol, toRow, toCol);
                break;
            default:
                System.out.println("There is no piece there!");
        }
    }

    /**
     *
     *  Bishop
     *
     */

    public void moveBishop(char color, int fromRow, int fromCol, int toRow, int toCol) {

        if (game.grid.isColor(game.grid.chessGrid[toRow][toCol], color)) {
            System.out.println("You can't move on top on your own piece");
        } else {
            for (int changeI = -1; changeI <= 1; changeI += 2) {
                for (int changeJ = -1; changeJ <= 1; changeJ += 2) {
                    int col = fromCol + changeJ;
                    for (int row = fromRow + changeI; row < 8 && row >= 0; row += changeI) {
                        if (col < 8 && col >= 0) {
                            if (toRow == row && toCol == col) {
                                game.grid.chessGrid[fromRow][fromCol] = Values.EMPTY;
                                game.grid.chessGrid[toRow][toCol] = game.grid.createPiece(color, Values.BISHOP);
                                game.nextTurn();
                                return;
                            } else if (game.grid.chessGrid[row][col] != Values.EMPTY) {
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

    public void moveRook(char color, int fromRow, int fromCol, int toRow, int toCol) {

        if (game.grid.isColor(game.grid.chessGrid[toRow][toCol], color)) {
            System.out.println("You can't move on top on your own piece");
        } else {
            // Castling from Rooks side
            if (game.whiteKingNotMoved == true) {
                if (game.whiteRookNotMovedA == true && fromCol == 0 && fromRow == 0 && toCol == 4 && toRow == 0) {
                    if (game.grid.chessGrid[0][1] == Values.EMPTY && game.grid.chessGrid[0][2] == Values.EMPTY && game.grid.chessGrid[0][3] == Values.EMPTY) {
                        game.grid.chessGrid[0][2] = game.grid.createPiece(color, Values.KING);
                        game.grid.chessGrid[0][3] = game.grid.createPiece(color, Values.ROOK);
                        game.whiteRookNotMovedA = false;
                        game.whiteKingNotMoved = false;
                        game.nextTurn();
                        return;
                    }
                } else if (game.whiteRookNotMovedH == true && fromCol == 7 && fromRow == 0 && toCol == 4 && toRow == 0) {
                    if (game.grid.chessGrid[0][5] == Values.EMPTY && game.grid.chessGrid[0][6] == Values.EMPTY) {
                        game.grid.chessGrid[0][6] = game.grid.createPiece(color, Values.KING);
                        game.grid.chessGrid[0][5] = game.grid.createPiece(color, Values.ROOK);
                        game.whiteRookNotMovedH = false;
                        game.whiteKingNotMoved = false;
                        game.nextTurn();
                        return;
                    }
                }
            } else if (game.blackKingNotMoved == true) {
                if (game.blackRookNotMovedA == true && fromCol == 0 && fromRow == 7 && toCol == 4 && toRow == 7) {
                    if (game.grid.chessGrid[7][1] == Values.EMPTY && game.grid.chessGrid[7][2] == Values.EMPTY && game.grid.chessGrid[7][3] == Values.EMPTY) {
                        game.grid.chessGrid[7][2] = game.grid.createPiece(color, Values.KING);
                        game.grid.chessGrid[7][3] = game.grid.createPiece(color, Values.ROOK);
                        game.blackRookNotMovedA = false;
                        game.blackKingNotMoved = false;
                        game.nextTurn();
                        return;
                    }
                } else if (game.blackRookNotMovedH == true && fromCol == 7 && fromRow == 7 && toCol == 4 && toRow == 7) {
                    if (game.grid.chessGrid[7][5] == Values.EMPTY && game.grid.chessGrid[7][6] == Values.EMPTY) {
                        game.grid.chessGrid[7][6] = game.grid.createPiece(color, Values.KING);
                        game.grid.chessGrid[7][5] = game.grid.createPiece(color, Values.ROOK);
                        game.blackRookNotMovedH = false;
                        game.blackKingNotMoved = false;
                        game.nextTurn();
                        return;
                    }
                }
            }
            for (int changeI = -1; changeI <= 1; changeI += 2) {
                int col = fromCol;
                for (int row = fromRow + changeI; row < 8 && row >= 0; row += changeI) {
                    if (toRow == row && toCol == col) {
                        game.grid.chessGrid[fromRow][fromCol] = Values.EMPTY;
                        game.grid.chessGrid[toRow][toCol] = game.grid.createPiece(color, Values.ROOK);
                        if (color == Values.WHITE) {
                            if (fromCol == 0 && fromRow == 0) {
                                game.whiteRookNotMovedA = false;
//                                System.out.println("whiteRookNotMovedA");
                            } else if (fromCol == 7 && fromRow == 0) {
                                game.whiteRookNotMovedH = false;
//                                System.out.println("whiteRookNotMovedH");
                            }
                        } else {
                            if (fromCol == 0 && fromRow == 7) {
                                game.blackRookNotMovedA = false;
//                                System.out.println("blackRookNotMovedA");
                            } else if (fromCol == 7 && fromRow == 7) {
                                game.blackRookNotMovedH = false;
//                                System.out.println("blackRookNotMovedH");
                            }
                        }
                        game.nextTurn();
                        return;
                    } else if (game.grid.chessGrid[row][col] != Values.EMPTY) {
                        break;
                    }
                }
            }
            for (int changeJ = -1; changeJ <= 1; changeJ += 2) {
                int row = fromRow;
                for (int col = fromCol + changeJ; col < 8 && col >= 0; col += changeJ) {
                    if (toRow == row && toCol == col) {
                        game.grid.chessGrid[fromRow][fromCol] = Values.EMPTY;
                        game.grid.chessGrid[toRow][toCol] = game.grid.createPiece(color, Values.ROOK);
                        if (color == Values.WHITE) {
                            if (fromCol == 0 && fromRow == 0) {
                                game.whiteRookNotMovedA = false;
//                                System.out.println("whiteRookNotMovedA");
                            } else if (fromCol == 7 && fromRow == 0) {
                                game.whiteRookNotMovedH = false;
//                                System.out.println("whiteRookNotMovedH");
                            }
                        } else {
                            if (fromCol == 0 && fromRow == 7) {
                                game.blackRookNotMovedA = false;
//                                System.out.println("blackRookNotMovedA");
                            } else if (fromCol == 7 && fromRow == 7) {
                                game.blackRookNotMovedH = false;
//                                System.out.println("blackRookNotMovedH");
                            }
                        }
                        game.nextTurn();
                        return;
                    } else if (game.grid.chessGrid[row][col] != Values.EMPTY) {
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

    public void moveQueen(char color, int fromRow, int fromCol, int toRow, int toCol) {

        if (game.grid.isColor(game.grid.chessGrid[toRow][toCol], color)) {
            System.out.println("You can't move on top on your own piece");
        } else {
            for (int changeI = -1; changeI <= 1; changeI += 2) {
                for (int changeJ = -1; changeJ <= 1; changeJ += 2) {
                    int col = fromCol + changeJ;
                    for (int row = fromRow + changeI; row < 8 && row >= 0; row += changeI) {
                        if (col < 8 && col >= 0) {
                            if (toRow == row && toCol == col) {
                                game.grid.chessGrid[fromRow][fromCol] = Values.EMPTY;
                                game.grid.chessGrid[toRow][toCol] = game.grid.createPiece(color, Values.QUEEN);
                                game.nextTurn();
                                return;
                            } else if (game.grid.chessGrid[row][col] != Values.EMPTY) {
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
                        game.grid.chessGrid[fromRow][fromCol] = Values.EMPTY;
                        game.grid.chessGrid[toRow][toCol] = game.grid.createPiece(color, Values.QUEEN);
                        game.nextTurn();
                        return;
                    } else if (game.grid.chessGrid[row][col] != Values.EMPTY) {
                        break;
                    }
                }
            }
            for (int changeJ = -1; changeJ <= 1; changeJ += 2) {
                int row = fromRow;
                for (int col = fromCol + changeJ; col < 8 && col >= 0; col += changeJ) {
                    if (toRow == row && toCol == col) {
                        game.grid.chessGrid[fromRow][fromCol] = Values.EMPTY;
                        game.grid.chessGrid[toRow][toCol] = game.grid.createPiece(color, Values.QUEEN);
                        game.nextTurn();
                        return;
                    } else if (game.grid.chessGrid[row][col] != Values.EMPTY) {
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

    public void moveKing(char color, int fromRow, int fromCol, int toRow, int toCol) {

        if (game.grid.isColor(game.grid.chessGrid[toRow][toCol], color)) {
            System.out.println("You can't move on top on your own piece");;
        } else {
            for (int changeI = -1; changeI <= 1; changeI += 2) {
                for (int changeJ = -1; changeJ <= 1; changeJ += 2) {
                    int col = fromCol + changeJ;
                    int row = fromRow + changeI;
                    if (col < 8 && col >= 0 && row < 8 && row >= 0) {
                        if ( toRow == row && toCol == col) {
                            game.grid.chessGrid[fromRow][fromCol] = Values.EMPTY;
                            game.grid.chessGrid[toRow][toCol] = game.grid.createPiece(color, Values.KING);
                            if (color == Values.WHITE) {
                                game.whiteKingNotMoved = false;
//                                System.out.println("whiteKingNotMoved");
                            } else {
                                game.blackKingNotMoved = false;
//                                System.out.println("blackKingNotMoved");
                            }
                            game.nextTurn();
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
                        game.grid.chessGrid[fromRow][fromCol] = Values.EMPTY;
                        game.grid.chessGrid[toRow][toCol] = game.grid.createPiece(color, Values.KING);
                        if (color == Values.WHITE) {
                            game.whiteKingNotMoved = false;
//                            System.out.println("whiteKingNotMoved");
                        } else {
                            game.blackKingNotMoved = false;
//                            System.out.println("blackKingNotMoved");
                        }
                        game.nextTurn();
                        return;
                    }
                }
            }
            for (int changeJ = -1; changeJ <= 1; changeJ += 2) {
                int row = fromRow;
                int col = fromCol + changeJ;
                if (col < 8 && col >= 0) {
                    if ( toRow == row && toCol == col) {
                        game.grid.chessGrid[fromRow][fromCol] = Values.EMPTY;
                        game.grid.chessGrid[toRow][toCol] = game.grid.createPiece(color, Values.KING);
                        if (color == Values.WHITE) {
                            game.whiteKingNotMoved = false;
//                            System.out.println("whiteKingNotMoved");
                        } else {
                            game.blackKingNotMoved = false;
//                            System.out.println("blackKingNotMoved");
                        }
                        game.nextTurn();
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

    public void moveKnight(char color, int fromRow, int fromCol, int toRow, int toCol) {

        if (game.grid.isColor(game.grid.chessGrid[toRow][toCol], color)) {
            System.out.println("You can't move on top on your own piece");
        } else {
            for (int changeI = -1; changeI <= 1; changeI += 2) {
                for (int changeJ = -2; changeJ <= 2; changeJ += 4) {
                    int col = fromCol + changeJ;
                    for (int row = fromRow + changeI; row < 8 && row >= 0; row += changeI) {
                        if ( toRow == row && toCol == col) {
                            game.grid.chessGrid[fromRow][fromCol] = Values.EMPTY;
                            game.grid.chessGrid[toRow][toCol] = game.grid.createPiece(color, Values.KNIGHT);
                            game.nextTurn();
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
                            game.grid.chessGrid[fromRow][fromCol] = Values.EMPTY;
                            game.grid.chessGrid[toRow][toCol] = game.grid.createPiece(color, Values.KNIGHT);
                            game.nextTurn();
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

    public void movePawn(char color, int fromRow, int fromCol, int toRow, int toCol) {

        if (color == Values.WHITE) {
            if (fromRow == 1) {
                int col = fromCol;
                for (int row = fromRow + 1; row < 4; row++) {
                    if ( toRow == row && toCol == col && game.grid.chessGrid[toRow][toCol] == Values.EMPTY) {
                        game.grid.chessGrid[fromRow][fromCol] = Values.EMPTY;
                        game.grid.chessGrid[toRow][toCol] = game.grid.createPiece(color, Values.PAWN);
                        game.nextTurn();
                        return;
                    } else if (game.grid.chessGrid[row][col] != Values.EMPTY) {
                        break;
                    }
                }
            } else if (fromRow != 1) {
                int col = fromCol;
                int row = fromRow + 1;
                if ( toRow == row && toCol == col && game.grid.chessGrid[toRow][toCol] == Values.EMPTY) {
                    game.grid.chessGrid[fromRow][fromCol] = Values.EMPTY;
                    game.grid.chessGrid[toRow][toCol] = game.grid.createPiece(color, Values.PAWN);
                    game.nextTurn();
                    return;
                }
            }
            for (int changeJ = -1; changeJ <= 1; changeJ += 2) {
                int col = fromCol + changeJ;
                int row = fromRow + 1;
                if ( toRow == row && toCol == col && game.grid.isBlack(game.grid.chessGrid[toRow][toCol]) == true) {
                    game.grid.chessGrid[fromRow][fromCol] = Values.EMPTY;
                    game.grid.chessGrid[toRow][toCol] = game.grid.createPiece(color, Values.PAWN);
                    game.nextTurn();
                    return;
                }
            }
        } else if (color == Values.BLACK) {
            if (fromRow == 6) {
                int col = fromCol;
                for (int row = fromRow - 1; row > 3; row--) {
                    if ( toRow == row && toCol == col && game.grid.chessGrid[toRow][toCol] == Values.EMPTY) {
                        game.grid.chessGrid[fromRow][fromCol] = Values.EMPTY;
                        game.grid.chessGrid[toRow][toCol] = game.grid.createPiece(color, Values.PAWN);
                        game.nextTurn();
                        return;
                    } else if (game.grid.chessGrid[row][col] != Values.EMPTY) {
                        break;
                    }
                }
            } else if (fromRow != 6) {
                int col = fromCol;
                int row = fromRow - 1;
                if ( toRow == row && toCol == col && game.grid.chessGrid[toRow][toCol] == Values.EMPTY) {
                    game.grid.chessGrid[fromRow][fromCol] = Values.EMPTY;
                    game.grid.chessGrid[toRow][toCol] = game.grid.createPiece(color, Values.PAWN);
                    game.nextTurn();
                    return;
                }
            }
            for (int changeJ = -1; changeJ <= 1; changeJ += 2) {
                int col = fromCol + changeJ;
                int row = fromRow - 1;
                if ( toRow == row && toCol == col && game.grid.isWhite(game.grid.chessGrid[toRow][toCol]) == true) {
                    game.grid.chessGrid[fromRow][fromCol] = Values.EMPTY;
                    game.grid.chessGrid[toRow][toCol] = game.grid.createPiece(color, Values.PAWN);
                    game.nextTurn();
                    return;
                }
            }

        }
    }

}

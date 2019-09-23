package no.bakkenbaeck.chessboardeditor.util

import no.bakkenbaeck.chessboardeditor.R
import no.bakkenbaeck.chessboardeditor.model.FenParseException
import no.bakkenbaeck.chessboardeditor.model.Piece
import no.bakkenbaeck.chessboardeditor.model.Position

object FenUtil {

    fun readFEN(fen: String): Position {
        val position = Position(fen)
        val words = fen.trim().split(" ")

        // Piece placement
        var rowColPair = 7 to 0
        val placementString = words[0]
        placementString.toCharArray().forEach {
            rowColPair = when (it) {
                '1' -> rowColPair.add(cols = 1)
                '2' -> rowColPair.add(cols = 2)
                '3' -> rowColPair.add(cols = 3)
                '4' -> rowColPair.add(cols = 4)
                '5' -> rowColPair.add(cols = 5)
                '6' -> rowColPair.add(cols = 6)
                '7' -> rowColPair.add(cols = 7)
                '8' -> rowColPair.add(cols = 8)
                '/' -> rowColPair.add(rows = -1).set(col = 0)
                'P' -> setPiece(position, rowColPair, Piece.WhitePawn())
                'N' -> setPiece(position, rowColPair, Piece.WhiteKnight())
                'B' -> setPiece(position, rowColPair, Piece.WhiteBishop())
                'R' -> setPiece(position, rowColPair, Piece.WhiteRook())
                'Q' -> setPiece(position, rowColPair, Piece.WhiteQueen())
                'K' -> setPiece(position, rowColPair, Piece.WhiteKing())
                'p' -> setPiece(position, rowColPair, Piece.BlackPawn())
                'n' -> setPiece(position, rowColPair, Piece.BlackKnight())
                'b' -> setPiece(position, rowColPair, Piece.BlackBishop())
                'r' -> setPiece(position, rowColPair, Piece.BlackRook())
                'q' -> setPiece(position, rowColPair, Piece.BlackQueen())
                'k' -> setPiece(position, rowColPair, Piece.BlackKing())
                else -> throw FenParseException(R.string.err_invalid_piece, position)
            }
        }

        return position
    }

    private fun Pair<Int, Int>.add(rows: Int = 0, cols: Int = 0): Pair<Int, Int> {
        return copy(first + rows, second + cols)
    }

    private fun Pair<Int, Int>.set(row: Int? = null, col: Int? = null): Pair<Int, Int> {
        return copy(row ?: first, col ?: second)
    }

    private fun setPiece(pos: Position, rowColPair: Pair<Int, Int>, piece: Piece): Pair<Int, Int> {
        pos.setPiece(rowColPair, piece)
        return rowColPair.add(cols = 1)
    }

    fun toFen(position: Position): String {
        val ret = StringBuilder()
        for (row in 7 downTo 0) {
            var numEmpty = 0
            for (col in 0..7) {
                val p = position.getPiece(row, col)
                if (p == null) {
                    numEmpty++
                } else {
                    if (numEmpty > 0) {
                        ret.append(numEmpty)
                        numEmpty = 0
                    }
                    when (p) {
                        is Piece.WhiteKing -> ret.append('K')
                        is Piece.WhiteQueen -> ret.append('Q')
                        is Piece.WhiteRook -> ret.append('R')
                        is Piece.WhiteBishop -> ret.append('B')
                        is Piece.WhiteKnight -> ret.append('N')
                        is Piece.WhitePawn -> ret.append('P')
                        is Piece.BlackKing -> ret.append('k')
                        is Piece.BlackQueen -> ret.append('q')
                        is Piece.BlackRook -> ret.append('r')
                        is Piece.BlackBishop -> ret.append('b')
                        is Piece.BlackKnight -> ret.append('n')
                        is Piece.BlackPawn -> ret.append('p')
                    }
                }
            }
            if (numEmpty > 0) {
                ret.append(numEmpty)
            }
            if (row > 0) {
                ret.append('/')
            }
        }

        val newFirstWord = ret.toString()
        val prevFirstWord = position.startingFen.split(" ").first()
        return position.startingFen.replace(prevFirstWord, newFirstWord)
    }
}
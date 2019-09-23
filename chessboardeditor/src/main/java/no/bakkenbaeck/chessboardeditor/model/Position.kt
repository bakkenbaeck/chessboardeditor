package no.bakkenbaeck.chessboardeditor.model

import no.bakkenbaeck.chessboardeditor.util.Constants.BOARD_SIZE

class Position(val startingFen: String) {
    private val pieces: MutableMap<Int, Piece> = mutableMapOf()


    fun setPiece(rowColPair: Pair<Int, Int>, piece: Piece?) {
        setPiece(row = rowColPair.first, col = rowColPair.second, piece = piece)
    }

    fun setPiece(row: Int, col: Int, piece: Piece?) {
        val index = getIndex(row = row, col = col)
        setPiece(index, piece)
    }

    fun setPiece(index: Int, piece: Piece?) {
        if (piece == null) pieces.remove(index)
        else pieces[index] = piece
    }

    fun getPiece(rowColPair: Pair<Int, Int>): Piece? {
        return getPiece(row = rowColPair.first, col = rowColPair.second)
    }

    fun getPiece(row: Int, col: Int): Piece? {
        val index = getIndex(row = row, col = col)
        return getPiece(index)
    }

    fun getPiece(index: Int): Piece? {
        return pieces[index]
    }

    fun forEach(action: (row: Int, col: Int, piece: Piece) -> Unit) {
        pieces.keys.forEach {
            val piece = pieces[it] ?: return
            val (row, col) = getRowCol(it)
            action(row, col, piece)
        }
    }

    private fun getIndex(row: Int, col: Int) = col * BOARD_SIZE + row

    private fun getRowCol(index: Int) = index % BOARD_SIZE to index / BOARD_SIZE

    fun makeMove(move: Move) {
        when (move) {
            is Move.NormalPieceMove -> {
                val fromPiece = getPiece(move.from) ?: return
                setPiece(move.from, null)
                setPiece(move.to, fromPiece)
            }
            is Move.InsertPieceMove -> {
                setPiece(move.to, move.piece)
            }
            is Move.RemovePieceMove -> {
                setPiece(move.from, null)
            }
        }
    }
}

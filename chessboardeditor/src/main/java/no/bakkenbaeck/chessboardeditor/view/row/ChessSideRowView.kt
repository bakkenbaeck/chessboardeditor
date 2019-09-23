package no.bakkenbaeck.chessboardeditor.view.row

import android.content.Context
import android.util.AttributeSet
import no.bakkenbaeck.chessboardeditor.model.Piece
import no.bakkenbaeck.chessboardeditor.util.Constants.BOARD_SIZE
import no.bakkenbaeck.chessboardeditor.view.cell.ChessSideCellView
import no.bakkenbaeck.chessboardeditor.view.piece.ChessPieceView

class ChessSideRowView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ChessRowView(context, attrs) {

    fun setSide(
        isWhite: Boolean,
        onDragEnded: ((cellTag: String, pieceTag: String) -> Unit)
    ) {
        val rowIndex = isWhiteToRowIndex(isWhite)
        setRow(rowIndex, onDragEnded)
    }

    override fun insertCells(
        rowIndex: Int,
        onDragEnded: (cellTag: String, pieceTag: String) -> Unit
    ) {
        (0 until BOARD_SIZE).forEach { insertCell(rowIndex, it, onDragEnded) }
    }

    private fun insertCell(
        rowIndex: Int,
        colIndex: Int,
        onDragEnded: ((cellTag: String, pieceTag: String) -> Unit)
    ) {
        val cell = ChessSideCellView(context)
        cell.setRowCol(rowIndex, colIndex)
        cell.setOnDragEnded(onDragEnded)
        insertPieceIfAvailable(cell, rowIndex, colIndex)
        addView(cell)
    }

    private fun insertPieceIfAvailable(
        cell: ChessSideCellView,
        rowIndex: Int,
        colIndex: Int
    ) {
        val piece = getPieceFromRowCol(rowIndex, colIndex) ?: return
        val pieceView = ChessPieceView(context)
        pieceView.setPiece(piece)
        cell.setPiece(pieceView)
    }

    companion object {
        private val whitePiecesForIndex = mapOf(
            1 to Piece.WhiteKing(),
            2 to Piece.WhiteQueen(),
            3 to Piece.WhiteRook(),
            4 to Piece.WhiteBishop(),
            5 to Piece.WhiteKnight(),
            6 to Piece.WhitePawn(),
            7 to Piece.Delete()
        )

        private val blackPiecesForIndex = mapOf(
            1 to Piece.BlackKing(),
            2 to Piece.BlackQueen(),
            3 to Piece.BlackRook(),
            4 to Piece.BlackBishop(),
            5 to Piece.BlackKnight(),
            6 to Piece.BlackPawn(),
            7 to Piece.Delete()
        )

        fun getPieceFromRowCol(rowIndex: Int, colIndex: Int): Piece? {
            val isWhite = rowIndexToIsWhite(rowIndex)
            val map = if (isWhite) whitePiecesForIndex else blackPiecesForIndex
            return map[colIndex]
        }

        private fun isWhiteToRowIndex(isWhite: Boolean) = if (isWhite) -1 else -2

        private fun rowIndexToIsWhite(rowIndex: Int) = rowIndex == isWhiteToRowIndex(true)
    }
}
package no.bakkenbaeck.chessboardeditor.view.row

import android.content.Context
import android.util.AttributeSet
import no.bakkenbaeck.chessboardeditor.util.Constants.BOARD_SIZE
import no.bakkenbaeck.chessboardeditor.view.cell.ChessInnerCellView

class ChessInnerRowView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ChessRowView(context, attrs) {

    public override fun setRow(
        rowIndex: Int,
        onDragEnded: (cellTag: String, pieceTag: String) -> Unit
    ) {
        super.setRow(rowIndex, onDragEnded)
    }

    override fun insertCells(
        rowIndex: Int,
        onDragEnded: (cellTag: String, pieceTag: String) -> Unit
    ) {
        (0 until BOARD_SIZE).forEach { insertCell(rowIndex, it, onDragEnded) }
    }

    private fun insertCell(rowIndex: Int, colIndex: Int, onDragEnded: ((cellTag: String, pieceTag: String) -> Unit)) {
        val cell = ChessInnerCellView(context)
        cell.setRowCol(rowIndex, colIndex)
        cell.setOnDragEnded(onDragEnded)
        addView(cell)
    }
}
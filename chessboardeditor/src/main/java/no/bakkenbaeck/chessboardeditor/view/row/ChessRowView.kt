package no.bakkenbaeck.chessboardeditor.view.row

import android.content.Context
import android.util.AttributeSet
import android.widget.TableLayout
import android.widget.TableRow
import no.bakkenbaeck.chessboardeditor.util.Constants.BOARD_SIZE

abstract class ChessRowView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : TableRow(context, attrs) {

    protected open fun setRow(
        rowIndex: Int,
        onDragEnded: ((cellTag: String, pieceTag: String) -> Unit)
    ) {
        insertCells(rowIndex, onDragEnded)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        if (w != oldw) fixHeight(w)
        super.onSizeChanged(w, h, oldw, oldh)
    }

    private fun fixHeight(width: Int) {
        val params = (layoutParams as? TableLayout.LayoutParams) ?: return
        params.height = width / BOARD_SIZE
        minimumHeight = width / BOARD_SIZE
        layoutParams = params
    }

    abstract fun insertCells(
        rowIndex: Int,
        onDragEnded: ((cellTag: String, pieceTag: String) -> Unit)
    )
}
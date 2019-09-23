package no.bakkenbaeck.chessboardeditor.view.cell

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import android.widget.TableRow
import no.bakkenbaeck.chessboardeditor.R
import no.bakkenbaeck.chessboardeditor.listener.CellOnDragListener
import no.bakkenbaeck.chessboardeditor.view.piece.ChessPieceView

abstract class ChessCellView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    init {
        setLayoutParams()
    }

    companion object {
        private const val PREFIX = "cell_view_"
        fun getTagFromRowCol(rowIndex: Int, colIndex: Int): String {
            return "$PREFIX${rowIndex}_$colIndex"
        }
    }

    fun getRowCol(): Pair<Int, Int> {
        val tag = tag as? String ?: return -1 to -1
        val rowColList = tag.removePrefix(PREFIX).split("_").map { it.toInt() }
        return rowColList[0] to rowColList[1]
    }

    fun setOnDragEnded(onDragEnded: ((cellTag: String, pieceTag: String) -> Unit)) {
        setOnDragListener(CellOnDragListener { view, dragData -> onDragEnded(view, dragData) })
    }

    fun setRowCol(row: Int, col: Int) {
        tag = getTagFromRowCol(row, col)
        paintCell(row, col)
    }

    private fun setLayoutParams() {
        val params = TableRow.LayoutParams()
        params.apply {
            width = 0
            height = MATCH_PARENT
            weight = 1f
        }

        val padding = context.resources.getDimensionPixelSize(R.dimen.pieceSpacing)
        setPadding(padding, padding, padding, padding)

        layoutParams = params
    }

    protected abstract fun paintCell(row: Int, col: Int)

    fun removePiece() {
        removeAllViews()
    }

    fun setPiece(pieceView: ChessPieceView) {
        removePiece()
        addView(pieceView)
    }
}
package no.bakkenbaeck.chessboardeditor.view.cell

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import no.bakkenbaeck.chessboardeditor.R

class ChessInnerCellView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ChessCellView(context, attrs, defStyleAttr) {
    override fun paintCell(row: Int, col: Int) {
        if (isLightCell(row, col)) setBackgroundColor(ContextCompat.getColor(context, R.color.boardCellLight))
        else setBackgroundColor(ContextCompat.getColor(context, R.color.boardCellDark))
    }

    private fun isLightCell(row: Int, col: Int) = (row + col) % 2 != 0
}
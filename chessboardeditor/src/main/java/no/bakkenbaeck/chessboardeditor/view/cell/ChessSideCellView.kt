package no.bakkenbaeck.chessboardeditor.view.cell

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import no.bakkenbaeck.chessboardeditor.R

class ChessSideCellView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ChessCellView(context, attrs, defStyleAttr) {

    override fun paintCell(row: Int, col: Int) {
        setBackgroundColor(ContextCompat.getColor(context, R.color.boardCellSide))
    }
}
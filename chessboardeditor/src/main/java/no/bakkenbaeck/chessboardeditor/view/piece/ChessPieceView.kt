package no.bakkenbaeck.chessboardeditor.view.piece

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import no.bakkenbaeck.chessboardeditor.listener.OnPieceTouchListener
import no.bakkenbaeck.chessboardeditor.model.Piece

class ChessPieceView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {

    private var piece: Piece? = null

    init {
        setLayoutParams()
        tag = "piece_view_${View.generateViewId()}"
    }

    fun setPiece(piece: Piece) {
        this.piece = piece
        setImageResource(piece.drawableRes)
        setDragDropListener()
    }

    fun getPiece() = piece

    private fun setLayoutParams() {
        val params = layoutParams as? FrameLayout.LayoutParams ?: return
        val parent = parent as? ViewGroup ?: return
        params.apply {
            height = parent.height
            width = parent.width
            gravity = Gravity.CENTER
        }

        layoutParams = params
    }

    private fun setDragDropListener() {
        setOnTouchListener(OnPieceTouchListener())
    }

}
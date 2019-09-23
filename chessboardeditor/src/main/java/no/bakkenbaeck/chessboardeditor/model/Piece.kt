package no.bakkenbaeck.chessboardeditor.model

import androidx.annotation.DrawableRes
import no.bakkenbaeck.chessboardeditor.R

sealed class Piece(@DrawableRes val drawableRes: Int) {
    class WhiteKing : Piece(R.drawable.ic_wk)
    class WhiteQueen : Piece(R.drawable.ic_wq)
    class WhiteRook : Piece(R.drawable.ic_wr)
    class WhiteBishop : Piece(R.drawable.ic_wb)
    class WhiteKnight : Piece(R.drawable.ic_wn)
    class WhitePawn : Piece(R.drawable.ic_wp)

    class BlackKing : Piece(R.drawable.ic_bk)
    class BlackQueen : Piece(R.drawable.ic_bq)
    class BlackRook : Piece(R.drawable.ic_br)
    class BlackBishop : Piece(R.drawable.ic_bb)
    class BlackKnight : Piece(R.drawable.ic_bn)
    class BlackPawn : Piece(R.drawable.ic_bp)

    class Delete : Piece(R.drawable.ic_delete)
}
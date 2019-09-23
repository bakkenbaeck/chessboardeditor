package no.bakkenbaeck.chessboardeditor.model

sealed class Move {
    class NormalPieceMove(val from: Pair<Int, Int>, val to: Pair<Int, Int>) : Move()
    class InsertPieceMove(val to: Pair<Int, Int>, val piece: Piece) : Move()
    class RemovePieceMove(val from: Pair<Int, Int>) : Move()
}
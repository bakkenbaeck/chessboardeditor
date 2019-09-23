package no.bakkenbaeck.chessboardeditor.listener

import android.view.DragEvent
import android.view.View

class CellOnDragListener(
    private val onDragEnded: (cellTag: String, pieceTag: String) -> Unit
) :
    View.OnDragListener {
    private var isItemInsideView = false
    override fun onDrag(view: View, event: DragEvent): Boolean {

        return when (event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                isItemInsideView = true
                true
            }

            DragEvent.ACTION_DRAG_LOCATION -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                isItemInsideView = false
                true
            }
            DragEvent.ACTION_DROP -> {
                true
            }

            DragEvent.ACTION_DRAG_ENDED -> {
                val piece = event.localState as? View ?: return false
                piece.alpha = 1f
                val pieceTag = piece.tag as? String ?: return false
                val cellTag = view.tag as? String ?: return false
                if (event.result && isItemInsideView) {
                    onDragEnded(cellTag, pieceTag)
                    isItemInsideView = false
                }
                true
            }
            else -> false
        }
    }
}
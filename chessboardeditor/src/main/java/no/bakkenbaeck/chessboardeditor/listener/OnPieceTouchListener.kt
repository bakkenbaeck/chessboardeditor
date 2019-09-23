package no.bakkenbaeck.chessboardeditor.listener

import android.content.ClipData
import android.content.ClipDescription
import android.view.MotionEvent
import android.view.View
import androidx.core.view.ViewCompat

class OnPieceTouchListener : View.OnTouchListener {
    override fun onTouch(view: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                val tagString = view.tag as? CharSequence ?: return false
                val item = ClipData.Item(tagString)
                val dragData = ClipData(tagString, arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN), item)
                ViewCompat.startDragAndDrop(view, dragData, View.DragShadowBuilder(view), view, 0)
                view.alpha = 0.3f
                return true
            }
            MotionEvent.ACTION_UP -> {
                view.performClick()
                return true
            }
            else -> return false
        }
    }
}
package com.ercan.hexalertdialog

import android.app.AlertDialog
import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView

class HexAlertDialog(private val context: Context) {

    var title: String = "Title"
    var message: String = "Message"
    var positiveBtnText: String = "Positive Button"
    var negativeBtnText: String = "Negative Button"

    var titleColor: Int = Color.parseColor("#000000")
    var titleBackgroundColor: Int = Color.parseColor("#ffffff")
    var titleDividerColor: Int = Color.parseColor("#FFD8D8D8")

    var messageColor: Int = Color.parseColor("#FF929292")
    var messageBackgroundColor: Int = Color.parseColor("#FFFFFF")

    var buttonDividerColor: Int = Color.parseColor("#FFD8D8D8")
    var positiveBtnTextColor: Int = Color.parseColor("#F05400")
    var positiveBtnBackgroundColor: Int = Color.parseColor("#FFFFFF")
    var negativeBtnTextColor: Int = Color.parseColor("#000000")
    var negativeBtnBackgroundColor: Int = Color.parseColor("#FFFFFF")
    var positiveImageBtnIcon: Int = R.drawable.ic_tick
    var negativeImageBtnIcon: Int = R.drawable.ic_cancel
    var dialogCornerRadius: Float = dpToPx(10F)
        set(value) {
            field = dpToPx(value)
        }

    var useIconButtons: Boolean = false
    var cancelOnTouchOutside: Boolean = true
    var showTitleDivider: Boolean = true
    var showButtonDivider: Boolean = true

    var textGravity: Int = Gravity.CENTER
    var position: Int = Gravity.CENTER
    var animation: Animation = Animation.TRANSPARENT_TO_OPAQUE

    // Click event for the positive and negative buttons. If these events are not defined,
    // then the positive and negative buttons will be invisible (View.GONE)
    var positiveBtnClickListener: () -> Unit = {}
    var negativeBtnClickListener: () -> Unit = {}

    fun show() {

        val dialogLayout =
            LayoutInflater.from(context).inflate(R.layout.hex_alert_dialog_layout, null)
        val dialogCardVw: CardView =
            dialogLayout.findViewById(R.id.dialogCardVw)
        val titleTextView: TextView =
            dialogLayout.findViewById(R.id.titleTw)
        val messageTextView: TextView =
            dialogLayout.findViewById(R.id.messageTw)
        val titleDivider: View =
            dialogLayout.findViewById(R.id.titleDivider)
        val positiveBtn: Button =
            dialogLayout.findViewById(R.id.positiveBtn)
        val positiveImageBtn: ImageButton =
            dialogLayout.findViewById(R.id.positiveImageBtn)
        val positiveBtnContainer: LinearLayout =
            dialogLayout.findViewById(R.id.positiveBtnContainer)
        val negativeBtn: Button =
            dialogLayout.findViewById(R.id.negativeBtn)
        val negativeImageBtn: ImageButton =
            dialogLayout.findViewById(R.id.negativeImageBtn)
        val negativeBtnContainer: LinearLayout =
            dialogLayout.findViewById(R.id.negativeBtnContainer)
        val buttonContainer: LinearLayout =
            dialogLayout.findViewById(R.id.buttonContainer)
        val buttonDivider: View =
            dialogLayout.findViewById(R.id.buttonDivider)
        val alertDialog =
            AlertDialog.Builder(context, animation.resId).setView(dialogLayout).create()

        if (positiveBtnClickListener == {})
            positiveBtnContainer.visibility = View.GONE
        if (negativeBtnClickListener == {})
            negativeBtnContainer.visibility = View.GONE
        if (positiveBtnClickListener == {} && negativeBtnClickListener == {})
            buttonContainer.visibility = View.GONE

        if (!showButtonDivider)
            buttonDivider.visibility = View.GONE
        if (!showTitleDivider)
            titleDivider.visibility = View.GONE

        alertDialog.window?.setGravity(position)
        alertDialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        alertDialog.setCanceledOnTouchOutside(cancelOnTouchOutside)

        titleTextView.text = title
        titleTextView.setTextColor(titleColor)
        titleTextView.setBackgroundColor(titleBackgroundColor)
        titleTextView.gravity = textGravity
        titleDivider.setBackgroundColor(titleDividerColor)
        messageTextView.text = message
        messageTextView.setTextColor(messageColor)
        messageTextView.setBackgroundColor(messageBackgroundColor)
        messageTextView.gravity = textGravity
        positiveBtnContainer.setBackgroundColor(positiveBtnBackgroundColor)
        negativeBtnContainer.setBackgroundColor(negativeBtnBackgroundColor)
        buttonDivider.setBackgroundColor(buttonDividerColor)
        dialogCardVw.radius = dialogCornerRadius

        if (!useIconButtons) {
            positiveImageBtn.visibility = View.GONE
            negativeImageBtn.visibility = View.GONE
            positiveBtn.text = positiveBtnText
            positiveBtn.setTextColor(positiveBtnTextColor)
            negativeBtn.text = negativeBtnText
            negativeBtn.setTextColor(negativeBtnTextColor)
            positiveBtn.setOnClickListener {
                positiveBtnClickListener()
                alertDialog.dismiss()
            }
            negativeBtn.setOnClickListener {
                negativeBtnClickListener()
                alertDialog.dismiss()
            }
        } else {
            positiveBtn.visibility = View.GONE
            negativeBtn.visibility = View.GONE
            positiveImageBtn.setImageResource(positiveImageBtnIcon)
            negativeImageBtn.setImageResource(negativeImageBtnIcon)
            positiveImageBtn.setOnClickListener {
                positiveBtnClickListener()
                alertDialog.dismiss()
            }
            negativeImageBtn.setOnClickListener {
                negativeBtnClickListener()
                alertDialog.dismiss()
            }
        }

        alertDialog.show()
    }

    private fun dpToPx(dp: Float): Float {
        return (dp * Resources.getSystem().displayMetrics.density)
    }
}
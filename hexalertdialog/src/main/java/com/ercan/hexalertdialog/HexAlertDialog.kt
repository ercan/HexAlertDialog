package com.ercan.hexalertdialog

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView

object HexAlertDialog {

    class Builder(private val context: Context) {

        private var title: String = "Title"
        private var message: String = "Message"
        private var positiveBtnText: String = "Positive Button"
        private var negativeBtnText: String = "Negative Button"

        private var titleColor: Int = Color.parseColor("#FFFFFF")
        private var titleBackgroundColor: Int = Color.parseColor("#262433")
        private var titleDividerColor: Int = Color.parseColor("#191A25")
        private var messageColor: Int = Color.parseColor("#FFFFFF")
        private var messageBackgroundColor: Int = Color.parseColor("#262433")
        private var positiveBtnTextColor: Int = Color.GREEN
        private var positiveImageBtnIcon: Int = R.drawable.ic_tick
        private var positiveBtnBackgroundColor: Int = Color.parseColor("#191A25")
        private var negativeBtnTextColor: Int = Color.RED
        private var negativeImageBtnIcon: Int = R.drawable.ic_cancel
        private var negativeBtnBackgroundColor: Int = Color.parseColor("#191A25")
        private var buttonDividerColor: Int = Color.parseColor("#262433")

        private var useIconButtons: Boolean = false
        private var cancelOnTouchOutside: Boolean = true
        private var showTitleDivider: Boolean = true
        private var showButtonDivider: Boolean = true

        private var textGravity: Int = Gravity.CENTER
        private var position: Int = Gravity.CENTER
        private var animation: Animation = Animation.TRANSPARENT_TO_OPAQUE

        private lateinit var positiveBtnClickListener: () -> Unit
        private lateinit var negativeBtnClickListener: () -> Unit

        // Sets the title of the dialog.
        fun setTitle(title: String) =
            apply { this.title = title }

        // Sets the message of the dialog.
        fun setMessage(message: String) =
            apply { this.message = message }

        // Sets the text of the positive button.
        fun setPositiveBtnText(positiveBtnText: String) =
            apply { this.positiveBtnText = positiveBtnText }

        // Sets the text of the negative button.
        fun setNegativeBtnText(negativeBtnText: String) =
            apply { this.negativeBtnText = negativeBtnText }

        // Sets the color of the title text.
        fun setTitleColor(titleColor: Int) =
            apply { this.titleColor = titleColor }

        // Sets the background color of the title.
        fun setTitleBackgroundColor(titleBackgroundColor: Int) =
            apply { this.titleBackgroundColor = titleBackgroundColor }

        // Sets the color of the divider between title and message.
        fun setTitleDividerColor(titleDividerColor: Int) =
            apply { this.titleDividerColor = titleDividerColor }

        // Sets the color of the message text.
        fun setMessageColor(messageColor: Int) =
            apply { this.messageColor = messageColor }

        // Sets the background color of the message.
        fun setMessageBackgroundColor(messageBackgroundColor: Int) =
            apply { this.messageBackgroundColor = messageBackgroundColor }

        // Sets the text color of the positive button.
        fun setPositiveBtnTextColor(positiveBtnTextColor: Int) =
            apply { this.positiveBtnTextColor = positiveBtnTextColor }

        // Sets the icon of the positive button. If icon buttons are required instead of text buttons
        // then @useIconButtons should be set to "true" by using @useIconButtons(Boolean) function
        fun setPositiveImageBtnIcon(resId: Int) =
            apply { this.positiveImageBtnIcon = resId }

        // Sets the background color of the positive button.
        // This function does also work for icon buttons.
        fun setPositiveBtnBackgroundColor(positiveBtnBackgroundColor: Int) =
            apply { this.positiveBtnBackgroundColor = positiveBtnBackgroundColor }

        // Sets the text color of the negative button.
        fun setNegativeBtnTextColor(negativeBtnTextColor: Int) =
            apply { this.negativeBtnTextColor = negativeBtnTextColor }

        // Sets the icon of the negative button. If icon buttons are required instead of text buttons
        // then @useIconButtons should be set to "true" by using @useIconButtons(Boolean) function
        fun setNegativeImageBtnIcon(resId: Int) =
            apply { this.negativeImageBtnIcon = resId }

        // Sets the background color of the positive button.
        // This function does also work for icon buttons.
        fun setNegativeBtnBackgroundColor(negativeBtnBackgroundColor: Int) =
            apply { this.negativeBtnBackgroundColor = negativeBtnBackgroundColor }

        // Sets the color of the divider between the positive and the negative buttons.
        fun setButtonDividerColor(buttonDividerColor: Int) =
            apply { this.buttonDividerColor = buttonDividerColor }

        // Indicates that icon buttons will be used instead of text buttons.
        fun useIconButtons(useIconButtons: Boolean) =
            apply { this.useIconButtons = useIconButtons }

        // dialog is canceled when outside is touched.
        fun cancelableOnTouchOutside(cancelOnTouchOutside: Boolean) =
            apply { this.cancelOnTouchOutside = cancelOnTouchOutside }

        // Shows a divider between the title and the message.
        fun showTitleDivider(showTitleDivider: Boolean) =
            apply { this.showTitleDivider = showTitleDivider }

        // Show a divider between the positive and the negative buttons.
        fun showButtonDivider(showButtonDivider: Boolean) =
            apply { this.showButtonDivider = showButtonDivider }

        // Sets the alignment of all texts in the dialog.
        fun setTextAlignment(textGravity: Int) =
            apply { this.textGravity = textGravity }

        // Sets the animation of the dialog by using Gravity class.
        fun setAnimation(animation: Animation) =
            apply { this.animation = animation }

        // Sets the position of the dialog by using Gravity class.
        fun setPosition(gravity: Int) =
            apply { this.position = gravity }

        // Click event for the positive button. If this function is not called,
        // then positive button will be invisible (View.GONE)
        fun setOnPositiveBtnClickListener(positiveBtnClickListener: () -> Unit) =
            apply { this.positiveBtnClickListener = positiveBtnClickListener }

        // Click event for the negative button. If this function is not called,
        // then negative button will be invisible (View.GONE)
        fun setOnNegativeBtnClickListener(negativeBtnClickListener: () -> Unit) =
            apply { this.negativeBtnClickListener = negativeBtnClickListener }

        @SuppressLint("InflateParams")
        fun build() {

            val animationStyle = when (animation) {
                Animation.LEFT_TO_RIGHT -> R.style.LeftToRightTheme
                Animation.RIGHT_TO_LEFT -> R.style.RightToLeftTheme
                Animation.BOTTOM_TO_TOP -> R.style.BottomToTopTheme
                Animation.TOP_TO_BOTTOM -> R.style.TopToBottomTheme
                Animation.TRANSPARENT_TO_OPAQUE -> R.style.TransparentToOpaqueTheme
            }

            val dialogLayout =
                LayoutInflater.from(context).inflate(R.layout.hex_alert_dialog_layout, null)
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
                AlertDialog.Builder(context, animationStyle).setView(dialogLayout).create()

            // If the click events of the positive and negative buttons are not set,
            // then only title and message will be shown.
            if (!this::positiveBtnClickListener.isInitialized)
                positiveBtnContainer.visibility = View.GONE
            if (!this::negativeBtnClickListener.isInitialized)
                negativeBtnContainer.visibility = View.GONE
            if (!this::positiveBtnClickListener.isInitialized && !this::negativeBtnClickListener.isInitialized) {
                buttonContainer.visibility = View.GONE
                this.cancelOnTouchOutside = true
                dialogLayout.setOnClickListener {
                    alertDialog.dismiss()
                }
            }

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

            // If client will use icon buttons instead of text buttons,
            // then text buttons will not be processed.
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
    }
}
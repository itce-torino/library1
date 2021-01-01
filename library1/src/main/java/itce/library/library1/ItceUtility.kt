package itce.library.library1

import android.app.Activity
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

object ItceUtility {
    var context: Activity? = null

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    enum class Answer {
        YES, NO, NEUTRAL                          // may be also -> , ERROR
    }


    private var choise: Answer = Answer.NO

    private fun infoDialog(
        activity: Activity,
        inMessage: String,
        modePos: String,
        modeNeg: String,
        modeNeut: String
    ) {

        val message = "ATTENTION!\n\n$inMessage\n\n"

        val builder = AlertDialog.Builder(activity)
        builder.setMessage(message)
                .setCancelable(false)
                // positive button text and action
                .setPositiveButton(modePos) { dialog, _ ->
                    choise = Answer.YES
                    userChoise(Answer.YES)
                    dialog.dismiss()
                }
                .setNegativeButton(modeNeg) { dialog, _ ->
                    userChoise(Answer.NO)
                    dialog.dismiss()
                }
                .setNeutralButton(modeNeut) { dialog, _ ->
                    choise = Answer.NEUTRAL
                    dialog.dismiss()
                }

        val alert = builder.create()
        alert.show()
    }

    private fun userChoise(choosen: Answer) {
        choise = choosen
        if (choosen === Answer.YES)
            Toast.makeText(context, "YOUR CHOISE YES", Toast.LENGTH_LONG)
                    .show()
        else
            if (choosen === Answer.NO)
                Toast.makeText(context, "YOUR CHOISE NO", Toast.LENGTH_LONG)
                        .show()
    }

    fun showToast(
        activity: Activity,
        message: String,
        modePos: String,
        modeNeg: String,
        modeNeut: String,
        stopExecution: Boolean = false
    ): Answer {
        if (message.isNotEmpty() && message.isNotBlank()) {

            if ((message.startsWith("error", ignoreCase = true))
                    or (message.startsWith("info", ignoreCase = true))
                    or (message.startsWith("question", ignoreCase = true))
                    or stopExecution
            )
                infoDialog(activity, message, modePos, modeNeg, modeNeut)
            else
                Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
        }

        return choise
    }

    fun todoFeature(activity: Activity) {
        Toast.makeText(activity, "Sorry, this feature is not available, yet.", Toast.LENGTH_LONG)
                .show()

    }
}
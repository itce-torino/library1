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

    private var choice: Answer = Answer.NO

    private fun infoDialog(
        activity: Activity,
        inMessage: String,
        modePos: String,
        funPos: Runnable?,
        modeNeg: String,
        funNeg: Runnable?,
        modeNeut: String,
        funNeut: Runnable?,
    ) {

        val message = "ATTENTION!\n\n$inMessage\n\n"

        val builder = AlertDialog.Builder(activity)
        builder.setMessage(message)
            .setCancelable(false)
            // positive button text and action
            .setPositiveButton(modePos) { dialog, _ ->
                choice = Answer.YES
                userChoice(Answer.YES, funPos)
                dialog.dismiss()
            }
            .setNegativeButton(modeNeg) { dialog, _ ->
                choice = Answer.YES
                userChoice(Answer.NO, funNeg)
                dialog.dismiss()
            }
            .setNeutralButton(modeNeut) { dialog, _ ->
                choice = Answer.NEUTRAL
                userChoice(Answer.NEUTRAL, funNeut)
                dialog.dismiss()
            }

        val alert = builder.create()
        alert.show()
    }


    private fun userChoice(chosen: Answer, function: Runnable?) {
        choice = chosen
        if (function != null) {
            function.run()
        } else
            Toast.makeText(context, "Your choice is: $choice", Toast.LENGTH_LONG)
                .show()
    }

    fun showToast(
        activity: Activity,
        message: String,
        modePos: String,
        functionPos: Runnable?,
        modeNeg: String,
        functionNeg: Runnable?,
        modeNeut: String,
        functionNeut: Runnable?,
        stopExecution: Boolean = false
    ): Answer {
        if (message.isNotEmpty() && message.isNotBlank()) {

            if ((message.startsWith("error", ignoreCase = true))
                or (message.startsWith("info", ignoreCase = true))
                or (message.startsWith("question", ignoreCase = true))
                or stopExecution
            )
                infoDialog(
                    activity, message,
                    modePos, functionPos,
                    modeNeg, functionNeg,
                    modeNeut, functionNeut
                )
            else
                Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
        }

        return choice
    }

    fun todoFeature(activity: Activity) {
        Toast.makeText(activity, "Sorry, this feature is not available, yet.", Toast.LENGTH_LONG)
            .show()

    }
}
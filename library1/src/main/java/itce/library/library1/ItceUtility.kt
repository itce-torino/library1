package itce.library.library1

import android.app.Activity
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.text.SimpleDateFormat
import java.util.*

object ItceUtility {

// region -- showDialog with options and external functions

    enum class Answer { YES, NO, NEUTRAL }

    private var choice: Answer = Answer.NO

    fun showDialog(
        activity: Activity,
        message: String,
        modePos: String,        // text of Button
        functionPos: Any?,      // name of a Runnable function or NULL
        modeNeg: String,
        functionNeg: Any?,
        modeNeut: String,
        functionNeut: Any?,
        stopExecution: Boolean = false
    ): Answer {
        if (message.isNotEmpty() && message.isNotBlank()) {

            if ((message.startsWith("error", ignoreCase = true))
                or (message.startsWith("info", ignoreCase = true))
                or (message.startsWith("question", ignoreCase = true))
                or stopExecution
            ) {
                val posRun = functionPos as Runnable? ?: none()
                val negRun = functionNeg as Runnable? ?: none()
                val neutRun = functionNeut as Runnable? ?: none()
                infoDialog(
                    activity, message,
                    modePos, posRun,
                    modeNeg, negRun,
                    modeNeut, neutRun
                )
            } else
                Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
        }
        return choice
    }

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
                userChoice(activity, Answer.YES, funPos)
                dialog.dismiss()
            }
            .setNegativeButton(modeNeg) { dialog, _ ->
                choice = Answer.NO
                userChoice(activity, Answer.NO, funNeg)
                dialog.dismiss()
            }
            .setNeutralButton(modeNeut) { dialog, _ ->
                choice = Answer.NEUTRAL
                userChoice(activity, Answer.NEUTRAL, funNeut)
                dialog.dismiss()
            }

        val alert = builder.create()
        alert.show()
    }

    private fun userChoice(context: Activity, chosen: Answer, function: Runnable?) {
        choice = chosen
        if (function != null) {
            function.run()
        } else
            Toast.makeText(context, "Your choice is: $choice", Toast.LENGTH_LONG)
                .show()
    }

    private fun none() = Runnable() {}
// endregion -----------------------------------------------------


    fun showToast(activity: Activity, message: String, duration: Int) {
        Toast.makeText(activity, message, duration).show()
    }

    fun todoFeature(activity: Activity) {
        Toast.makeText(activity, "Sorry, this feature is not available yet.", Toast.LENGTH_LONG)
            .show()
    }

// region -- Epoch MILLISECONDS functions ----------------------------------

    // format use example "yyyy-MM-dd HH:mm"

    fun dateTimeToMillis(dateTime: String, format: String): Long {
        val date = SimpleDateFormat(format, Locale.ROOT).parse(dateTime)!!
        return date.time
    }
    fun dateTimeToMillis(date: Date, format: String): Long {
        return date.time
    }

    fun millisToDateTime(milliSeconds: Long, format: String): String {
        val dateTimeFormat = SimpleDateFormat(format, Locale.ROOT)
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliSeconds
        return dateTimeFormat.format(calendar.time)
    }

    fun millisToDateTime(milliSeconds: Long): Date {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = milliSeconds
        return calendar.time
    }

// endregion -------------------------------------------------------------------
}
package itce.library.library1

import android.app.Activity
import android.widget.Toast

object ItceHelper {

    fun justToast(activity: Activity, message: String, duration: Int) {
        Toast.makeText(activity, message, duration).show()
    }

}
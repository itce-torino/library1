package itce.library.host

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import itce.library.library1.ItceHelper
import itce.library.library1.ItceUtility
import itce.library.library1.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ret = thisDisplay()
        ItceUtility.showToast(
            this,
            "Ecco il messaggio: " + ret.toString(),
            "Yes",
            //  funPos = thisDisplay(),
            "NO",
            "Cancel",
            true
        )
    }

    private fun thisDisplay() {
        ItceHelper.justToast(
            this,
            ItceUtility.sum(16, 20).toString(),
            2
        )
    }

}
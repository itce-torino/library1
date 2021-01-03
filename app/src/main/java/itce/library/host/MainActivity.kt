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


        ItceUtility.showToast(
            this,
            "Execution of 'ItceUtility.sum(16, 20)' (on Yes)",
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
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

        val ret = display()


    }

    fun display(): Int {
      //  return Utility.sum(16 + 20)
        return (16 + 20)
    }

}
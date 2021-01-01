package itce.library.itcelibraryhost

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import itce.library.library1.Utility

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ret = display()
    }

    fun display(): Int {
        return 16 + 20
    }

}
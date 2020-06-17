package non.shahad.core.activity

import android.graphics.Color
import android.os.Build
import android.view.View
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class InjectionActivity : AppCompatActivity() {
    @get:LayoutRes
    abstract val layoutRes: Int

    fun wantToMakeStatusBarWhite(yes : Boolean){
        if (yes){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                window.statusBarColor = Color.WHITE
            }
        }
    }
}
package non.shahad.today.presentation.exts

import android.content.Context
import android.content.Intent
import non.shahad.detail.presentation.NewsDetailActivity

fun Context.switchToDetail(url: String){
    Intent(this,NewsDetailActivity::class.java).also {
        it.putExtra("URL",url)
        startActivity(it)
    }
}
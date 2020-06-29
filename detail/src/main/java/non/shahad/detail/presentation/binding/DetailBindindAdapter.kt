package non.shahad.detail.presentation.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.api.load
import non.shahad.core.extensions.gone

@BindingAdapter("bindBannerImage")
fun bindBannerImage(imageView: ImageView,url: String?){
    if (url != null){
        imageView.load(url)
    }else imageView.gone()
}

@BindingAdapter("bindCaption")
fun bindCaption(textView: TextView,caption: String?){
    if (caption != null){
        textView.text = caption
    }else textView.gone()
}
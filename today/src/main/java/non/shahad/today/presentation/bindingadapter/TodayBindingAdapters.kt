package non.shahad.today.presentation.bindingadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load
import non.shahad.today.domain.model.ImgDomainModel

@BindingAdapter("bindNewsImage")
fun bindNewsImage(imageView: ImageView, imgUrls: ImgDomainModel?){
    if (imgUrls != null){
        if (imgUrls.large != null) {
            imageView.load(imgUrls.large)
            return
        }
        imageView.load(imgUrls.default)
    }


}
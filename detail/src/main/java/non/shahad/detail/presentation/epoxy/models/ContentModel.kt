package non.shahad.detail.presentation.epoxy.models

import android.content.Context
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import non.shahad.core.epoxy.DataBindingModel
import non.shahad.detail.R
import non.shahad.detail.databinding.ContentItemBinding

@EpoxyModelClass
abstract class ContentModel: DataBindingModel<ContentItemBinding>() {

    @EpoxyAttribute
    lateinit var content: String

    override fun getDefaultLayout(): Int = R.layout.content_item

    override fun bind(binding: ContentItemBinding, context: Context) {
        binding.content = content
    }

    override fun unbind(binding: ContentItemBinding) {
        binding.content = null
    }

}
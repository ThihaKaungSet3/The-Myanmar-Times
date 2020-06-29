package non.shahad.detail.presentation.epoxy.models

import android.content.Context
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import non.shahad.core.epoxy.DataBindingModel
import non.shahad.detail.R
import non.shahad.detail.databinding.TitleItemBinding

@EpoxyModelClass
abstract class TitleModel: DataBindingModel<TitleItemBinding>() {

    @EpoxyAttribute
    lateinit var title: String

    override fun bind(binding: TitleItemBinding, context: Context) {
        binding.title = title
    }

    override fun unbind(binding: TitleItemBinding) {
        binding.title = null
    }

    override fun getDefaultLayout(): Int = R.layout.title_item
}
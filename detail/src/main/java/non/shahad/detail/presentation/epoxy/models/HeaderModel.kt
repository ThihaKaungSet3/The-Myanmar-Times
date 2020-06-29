package non.shahad.detail.presentation.epoxy.models

import android.content.Context
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import non.shahad.core.epoxy.DataBindingModel
import non.shahad.detail.R
import non.shahad.detail.databinding.HeaderItemBinding

@EpoxyModelClass
abstract class HeaderModel: DataBindingModel<HeaderItemBinding>(){

    @EpoxyAttribute
    lateinit var header: Pair<String,String>

    override fun bind(binding: HeaderItemBinding, context: Context) {
        binding.author = header.first
        binding.dateTime = header.second
    }

    override fun unbind(binding: HeaderItemBinding) {
        binding.dateTime = null
        binding.author = null
    }

    override fun getDefaultLayout(): Int = R.layout.header_item

}
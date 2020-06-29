package non.shahad.detail.presentation.epoxy.models

import android.content.Context
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import non.shahad.core.epoxy.DataBindingModel
import non.shahad.detail.R
import non.shahad.detail.databinding.SummaryItemBinding

@EpoxyModelClass
abstract class SummaryModel : DataBindingModel<SummaryItemBinding>(){

    @EpoxyAttribute
    lateinit var summary: String

    override fun getDefaultLayout(): Int = R.layout.summary_item

    override fun bind(binding: SummaryItemBinding, context: Context) {
        binding.summary = summary
    }

    override fun unbind(binding: SummaryItemBinding) {
        binding.summary = null
    }

}
package non.shahad.today.presentation.epoxy.model

import android.content.Context
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import non.shahad.core.epoxy.DataBindingModel
import non.shahad.today.R
import non.shahad.today.databinding.RegionalListItemBinding
import non.shahad.today.domain.model.NewsDomainModel

@EpoxyModelClass
abstract class RegionalListModel: DataBindingModel<RegionalListItemBinding>() {

    @EpoxyAttribute
    lateinit var news_: NewsDomainModel
    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    lateinit var onClick: (url: String) -> Unit

    override fun bind(binding: RegionalListItemBinding, context: Context) {
        binding.news = news_
    }

    override fun unbind(binding: RegionalListItemBinding) {
        binding.news = null
        binding.root.setOnClickListener {
            onClick(news_.link)
        }
    }

    override fun getDefaultLayout(): Int = R.layout.regional_list_item
}
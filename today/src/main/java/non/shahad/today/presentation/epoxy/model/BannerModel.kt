package non.shahad.today.presentation.epoxy.model

import android.content.Context
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import non.shahad.core.epoxy.DataBindingModel
import non.shahad.today.R
import non.shahad.today.databinding.BannerItemBinding

import non.shahad.today.domain.model.NewsDomainModel

@EpoxyModelClass
abstract class BannerModel: DataBindingModel<BannerItemBinding>(){

    @EpoxyAttribute
    lateinit var banner: NewsDomainModel
    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    lateinit var onClick: (url: String) -> Unit

    override fun getDefaultLayout(): Int = R.layout.banner_item

    override fun bind(binding: BannerItemBinding, context: Context) {
        binding.news = banner
    }

    override fun unbind(binding: BannerItemBinding) {
        binding.news = null
    }

}
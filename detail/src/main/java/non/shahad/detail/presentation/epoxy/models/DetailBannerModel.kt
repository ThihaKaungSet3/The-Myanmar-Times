package non.shahad.detail.presentation.epoxy.models


import android.content.Context
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import non.shahad.core.epoxy.DataBindingModel
import non.shahad.detail.R
import non.shahad.detail.databinding.DetailBannerBinding
import non.shahad.detail.domain.model.ImgDomainModel

@EpoxyModelClass
abstract class DetailBannerModel: DataBindingModel<DetailBannerBinding>(){

    @EpoxyAttribute
    lateinit var img: ImgDomainModel

    override fun getDefaultLayout(): Int = R.layout.detail_banner

    override fun bind(binding: DetailBannerBinding, context: Context) {
        binding.img = img
    }

    override fun unbind(binding: DetailBannerBinding) {
        binding.img = null
    }
}
package non.shahad.today.presentation.epoxy.model

import android.content.Context
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import non.shahad.core.epoxy.DataBindingModel
import non.shahad.today.R
import non.shahad.today.databinding.LatestNewsItemBinding
import non.shahad.today.domain.model.NewsDomainModel

@EpoxyModelClass
abstract class LatestNewsModel: DataBindingModel<LatestNewsItemBinding>() {

    @EpoxyAttribute
    lateinit var news: NewsDomainModel
    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    lateinit var onClick: (url: String) -> Unit

    override fun bind(binding: LatestNewsItemBinding, context: Context) {
        binding.news = news
        binding.root.setOnClickListener {
            onClick(news.link)
        }
    }

    override fun unbind(binding: LatestNewsItemBinding) {
        binding.news = null
    }

    override fun getDefaultLayout(): Int = R.layout.latest_news_item
}
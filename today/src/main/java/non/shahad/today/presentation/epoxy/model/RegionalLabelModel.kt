package non.shahad.today.presentation.epoxy.model

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import non.shahad.today.R

@EpoxyModelClass
abstract class RegionalLabelModel: EpoxyModelWithHolder<RegionalLabelModel.RegionalLabelHolder>(){

    @EpoxyAttribute
    lateinit var title: String

    override fun getDefaultLayout(): Int = R.layout.regional_label

    override fun bind(holder: RegionalLabelHolder) {
        holder.titleTV.text = title
    }

    inner class RegionalLabelHolder: EpoxyHolder(){
        lateinit var titleTV : TextView

        override fun bindView(itemView: View) {
            titleTV = itemView.findViewById(R.id.titleTV)
        }
    }
}
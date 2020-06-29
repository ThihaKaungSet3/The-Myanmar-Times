package non.shahad.today.presentation.epoxy.model

import android.view.View
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import non.shahad.today.R

@EpoxyModelClass
abstract class LatestLabel : EpoxyModelWithHolder<LatestLabel.LatestLabelHolder>(){

    override fun getDefaultLayout(): Int = R.layout.latest_label

    override fun bind(holder: LatestLabelHolder) {
        // Nothing
    }

    inner class LatestLabelHolder: EpoxyHolder(){
        override fun bindView(itemView: View) {
            // Nothing
        }
    }
}
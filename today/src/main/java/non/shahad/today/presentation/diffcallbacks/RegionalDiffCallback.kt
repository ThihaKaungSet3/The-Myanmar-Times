package non.shahad.today.presentation.diffcallbacks

import androidx.recyclerview.widget.DiffUtil
import non.shahad.today.domain.model.RegionalDomainModel

object RegionalDiffCallback :  DiffUtil.ItemCallback<RegionalDomainModel>() {
    override fun areItemsTheSame(
        oldItem: RegionalDomainModel,
        newItem: RegionalDomainModel
    ): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(
        oldItem: RegionalDomainModel,
        newItem: RegionalDomainModel
    ): Boolean {
        return oldItem.cards == newItem.cards
    }


}
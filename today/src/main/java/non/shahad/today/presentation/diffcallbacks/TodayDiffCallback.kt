package non.shahad.today.presentation.diffcallbacks

import androidx.recyclerview.widget.DiffUtil
import non.shahad.today.domain.model.TodayDomainModel

object TodayDiffCallback : DiffUtil.ItemCallback<TodayDomainModel>() {

    override fun areItemsTheSame(oldItem: TodayDomainModel, newItem: TodayDomainModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TodayDomainModel, newItem: TodayDomainModel): Boolean {
        return oldItem.viewTypes == newItem.viewTypes
    }
}
package non.shahad.today.presentation.diffcallbacks

import androidx.recyclerview.widget.DiffUtil
import non.shahad.today.domain.model.TodayDataModel

object TodayDiffCallback : DiffUtil.ItemCallback<TodayDataModel>() {

    override fun areItemsTheSame(oldItem: TodayDataModel, newItem: TodayDataModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TodayDataModel, newItem: TodayDataModel): Boolean {
        return oldItem.viewTypes == newItem.viewTypes
    }
}
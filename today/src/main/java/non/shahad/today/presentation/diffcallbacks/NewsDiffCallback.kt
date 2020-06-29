package non.shahad.today.presentation.diffcallbacks

import androidx.recyclerview.widget.DiffUtil
import non.shahad.today.domain.model.NewsDomainModel

object NewsDiffCallback :  DiffUtil.ItemCallback<NewsDomainModel>() {

    override fun areItemsTheSame(oldItem: NewsDomainModel, newItem: NewsDomainModel): Boolean {
        return oldItem.type == newItem.type
    }

    override fun areContentsTheSame(oldItem: NewsDomainModel, newItem: NewsDomainModel): Boolean {
        return oldItem.title == newItem.title
    }
}
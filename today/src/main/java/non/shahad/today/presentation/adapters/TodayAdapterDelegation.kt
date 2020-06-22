package non.shahad.today.presentation.adapters

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import non.shahad.today.domain.model.TodayDataModel
import non.shahad.today.presentation.diffcallbacks.TodayDiffCallback

class TodayAdapterDelegation: AsyncListDifferDelegationAdapter<TodayDataModel>(TodayDiffCallback){

}
package non.shahad.core.epoxy

import android.view.View
import androidx.annotation.CallSuper
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.EpoxyHolder

class DataBindingEpoxyHolder: EpoxyHolder() {

    lateinit var binding: ViewDataBinding

    @CallSuper
    override fun bindView(itemView: View) {
        binding = DataBindingUtil.bind(itemView)!!
    }
}
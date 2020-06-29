package non.shahad.core.epoxy

import android.content.Context
import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.EpoxyModelWithHolder

@Suppress("UNCHECKED_CAST")
abstract class DataBindingModel<in T: ViewDataBinding>: EpoxyModelWithHolder<DataBindingEpoxyHolder>() {

    abstract fun bind(binding: T,context: Context)

    abstract fun unbind(binding: T)

    override fun bind(holder: DataBindingEpoxyHolder) {
        val binding = holder.binding as? T ?: return
        val context = binding.root.context
        bind(binding,context)
    }

    override fun unbind(holder: DataBindingEpoxyHolder) {
        val binding = holder.binding as? T ?: return
        unbind(binding)
    }
}
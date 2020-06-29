package non.shahad.core.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

fun bindView(container : ViewGroup,layoutRes : Int) : ViewDataBinding {
    return DataBindingUtil.inflate(layoutInflater(container),layoutRes,container,false)
}

fun inflatedView(container: ViewGroup,layoutRes: Int) : View {
    return layoutInflater(container).inflate(layoutRes,container)
}

fun layoutInflater(container : ViewGroup) : LayoutInflater{
    return LayoutInflater.from(container.context)
}
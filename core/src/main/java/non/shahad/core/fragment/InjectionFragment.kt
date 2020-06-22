package non.shahad.core.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import javax.inject.Inject

abstract class InjectionFragment<M: ViewModel> : Fragment() {

    @Inject
    lateinit var viewModel: M

    @get:LayoutRes
    abstract val layoutRes: Int

    abstract fun onInitDI()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutRes,container,false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onInitDI()
    }

}
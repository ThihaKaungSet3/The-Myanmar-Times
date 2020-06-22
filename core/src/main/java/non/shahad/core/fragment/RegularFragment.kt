package non.shahad.core.fragment

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

 abstract class RegularFragment: Fragment() {
    @get:LayoutRes
    abstract val layoutRes: Int
}
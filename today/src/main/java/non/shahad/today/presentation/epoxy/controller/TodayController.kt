package non.shahad.today.presentation.epoxy.controller

import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.OnModelBuildFinishedListener
import non.shahad.core.extensions.timber
import non.shahad.today.domain.model.NewsDomainModel
import non.shahad.today.domain.types.RegionalNews
import non.shahad.today.presentation.epoxy.model.*
import java.util.HashSet

class TodayController(
        private val onItemClick: (String) -> Unit = {}
) : EpoxyController() {

    override fun buildModels() {

    }


}
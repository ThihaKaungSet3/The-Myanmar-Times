package non.shahad.today.presentation.epoxy.custom

import android.os.Handler
import com.airbnb.epoxy.EpoxyController

abstract class Typed8EpoxyController<A,B,C,D,E,F,G,H>: EpoxyController {

    constructor() : super()
    constructor(modelBuildingHandler: Handler,diffingHandler: Handler) : super(modelBuildingHandler,diffingHandler)

    private var data: A? = null
    private var data1: B? = null
    private var data2: C? = null
    private var data3: D? = null
    private var data4: E? = null
    private var data5: F? = null
    private var data6: G? = null
    private var data7: H? = null

    private var allowModelBuildRequest = false


    override fun moveModel(fromPosition: Int, toPosition: Int) {
        allowModelBuildRequest = true
        super.moveModel(fromPosition, toPosition)
        allowModelBuildRequest = false
    }

    override fun requestDelayedModelBuild(delayMs: Int) {
        if (!allowModelBuildRequest){
            throw IllegalStateException(
                "You cannot call `requestModelBuild` directly. Call `setData` instead to trigger a "
                        + "model refresh with new data."
            )
        }
        super.requestDelayedModelBuild(delayMs)
    }

    override fun requestModelBuild() {
        if (!allowModelBuildRequest){
            throw IllegalStateException(
                "You cannot call `requestModelBuild` directly. Call `setData` instead to trigger a "
                        + "model refresh with new data."
            )
        }
        super.requestModelBuild()
    }

    override fun buildModels() {
        if (!isBuildingModels){
            throw IllegalStateException(
                "You cannot call `buildModels` directly. Call `setData` instead to trigger a model "
                        + "refresh with new data."
            )
        }
        buildModels(data!!,data1!!,data2!!,data3!!,data4!!,data5!!,data6!!,data7!!)
    }

    fun setData(
        data: A?,data1: B?,data2: C?,data3: D?,
        data4: E?,data5: F?,data6: G?,data7: H?
    ){
        this.data = data
        this.data1 = data1
        this.data2 = data2
        this.data3 = data3
        this.data4 = data4
        this.data5 = data5
        this.data6 = data6
        this.data7 = data7
        allowModelBuildRequest = true
        requestModelBuild()
        allowModelBuildRequest = false
    }

    abstract fun buildModels(
        data: A?,data1: B?,data2: C?,data3: D?,
        data4: E?,data5: F?,data6: G?,data7: H?
    )

}
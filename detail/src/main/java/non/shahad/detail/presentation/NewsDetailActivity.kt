package non.shahad.detail.presentation

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_news_detail.*

import non.shahad.core.activity.InjectionActivity
import non.shahad.core.extensions.coreComponent
import non.shahad.core.extensions.timber
import non.shahad.detail.R
import non.shahad.detail.di.DaggerNewsDetailComponent
import non.shahad.detail.presentation.epoxy.controller.DetailEpoxyController
import javax.inject.Inject

class NewsDetailActivity : InjectionActivity() {

    @Inject lateinit var factory: ViewModelProvider.Factory

    private val controller = DetailEpoxyController()

    private val vm by lazy { ViewModelProviders.of(this,factory).get(NewsDetailViewModel::class.java) }

    override val layoutRes: Int
        get() = R.layout.activity_news_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)

        onInitDI()
        onInitRecyclerView()

        backBtn.setOnClickListener { finish() }

        intent.extras?.getString("URL").also {
            vm.fetchDetail(it!!)
        }

        vm.response.observe(this, Observer {
            controller.mutate(it)
        })
    }

    private fun onInitRecyclerView(){
        detailRV.adapter = controller.adapter
        controller.requestModelBuild()
    }

    private fun onInitDI(){
        DaggerNewsDetailComponent
            .builder()
            .coreComponent(coreComponent())
            .build()
            .inject(this)
    }
}
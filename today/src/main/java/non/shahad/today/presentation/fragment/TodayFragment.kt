package non.shahad.today.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_today.*
import non.shahad.core.extensions.coreComponent
import non.shahad.core.extensions.timber
import non.shahad.core.fragment.InjectionFragment
import non.shahad.core.recyclerview.RecyclerViewPaginator
import non.shahad.today.R
import non.shahad.today.di.DaggerTodayComponent
import non.shahad.today.di.TodayModule
import non.shahad.today.presentation.epoxy.controller.TodayController
import non.shahad.today.presentation.exts.switchToDetail

class TodayFragment : InjectionFragment<TodayViewModel>() {

    override val layoutRes: Int
        get() = R.layout.fragment_today

    private val controller by lazy {
        TodayController(
            onItemClick = {context!!.switchToDetail(it)}
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createRecyclerView()

    }

    private fun createRecyclerView(){
        todayRV.apply {
            adapter = controller.adapter
            controller.requestModelBuild()

            RecyclerViewPaginator(
                    this,
                    isLoading = {viewModel.isLoading},
                    loadMore = {
                        viewModel.fetchNewsByCategory(it)
                        timber("Today_","$it")
                    },
                    onLast = {
                        it >= 4
                    }
            )
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.fetchTodayFeeds(1)

        viewModel.feeds.observe(viewLifecycleOwner, Observer {

            if (it.bannerNews.isNullOrEmpty().not()) controller.addBanner(it!!.bannerNews!![0])
            if (it.latestNews.isNullOrEmpty().not()) controller.addLatestNews(it.latestNews!!)
        })

        viewModel.newsByCategory.observe(viewLifecycleOwner, Observer {
            controller.addNewsByCategory(Pair(1,it))
        })
    }

    override fun onInitDI() {
        DaggerTodayComponent
            .builder()
            .coreComponent(requireActivity().coreComponent())
            .todayModule(TodayModule(this))
            .build()
            .inject(this)
    }

}
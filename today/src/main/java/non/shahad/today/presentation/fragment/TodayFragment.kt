package non.shahad.today.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_today.*
import kotlinx.coroutines.InternalCoroutinesApi
import non.shahad.core.extensions.coreComponent
import non.shahad.core.extensions.timber
import non.shahad.core.fragment.InjectionFragment
import non.shahad.core.recyclerview.RecyclerViewPaginator
import non.shahad.today.R
import non.shahad.today.di.DaggerTodayComponent
import non.shahad.today.di.TodayModule
import non.shahad.today.domain.constants.NewsCategory
import non.shahad.today.presentation.epoxy.controller.TodayController
import non.shahad.today.presentation.epoxy.controller.TodayTypeController
import non.shahad.today.presentation.exts.switchToDetail

class TodayFragment : InjectionFragment<TodayViewModel>() {

    override val layoutRes: Int
        get() = R.layout.fragment_today

    private val controller by lazy {
        TodayController(
            onItemClick = {context?.switchToDetail(it)}
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createRecyclerView()

    }

    private fun createRecyclerView(){
        todayRV.apply {
            adapter = controller.adapter

            RecyclerViewPaginator(
                    this,
                    isLoading = {viewModel.isLoading},
                    loadMore = {
                        viewModel.streamNewsByCategory(it)
                    },
                    onLast = {
                        it > 6
                    }
            )
        }
    }

    @InternalCoroutinesApi
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.streamLatestNews()

        viewModel.feeds.observe(viewLifecycleOwner, Observer {
            timber("Controller!","Returned ${it}")
            if (it.isNullOrEmpty().not()){

                val latestNews = it.filterIndexed { index, _ ->
                    return@filterIndexed index > 0
                }

                controller.addBanner(it[0])
                controller.addLatestNews(latestNews)
            }


        })

        viewModel.newsByCategory.observe(viewLifecycleOwner, Observer {
              controller.addNewsByCategory(it)
//            when(it.first){
//                NewsCategory.COVID -> controller.setData(null,null,it.second,null,null,null,null,null)
//                NewsCategory.NATIONAL -> controller.setData(null,null,null,it.second,null,null,null,null)
//                NewsCategory.WORLD -> controller.setData(null,null,null,null,it.second,null,null,null)
//                NewsCategory.BUSINESS -> controller.setData(null,null,null,null,null,it.second,null,null)
//                NewsCategory.LIFESTYLE -> controller.setData(null,null,null,null,null,null,it.second,null)
//                NewsCategory.SPORTS -> controller.setData(null,null,null,null,null,null,null,it.second)
//            }
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
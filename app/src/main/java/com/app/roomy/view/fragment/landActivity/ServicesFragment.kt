package com.app.roomy.view.fragment.landActivity


import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager

import com.app.roomy.R
import com.app.roomy.adapter.ServiceSliderAdapter
import com.app.roomy.adapter.ServicesRecyclerAdapter
import com.app.roomy.view.uiConfig.BaseFragment
import kotlinx.android.synthetic.main.fragment_services.*

class ServicesFragment : BaseFragment() {

    private lateinit var handlerRunnable: Runnable
    private lateinit var myHandler: Handler
    private var sliderIndex: Int = 0
    private lateinit var sliderAdapter: ServiceSliderAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_services, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindSlider()
        bindServicesRecyclerView()

    }

    private fun bindServicesRecyclerView()
    {
        recyclerServices.layoutManager = LinearLayoutManager(fragmentContext, RecyclerView.VERTICAL, false)
        recyclerServices.adapter = ServicesRecyclerAdapter()
    }

    private fun bindSlider()
    {
        sliderAdapter = ServiceSliderAdapter()
        sliderViewPager.clipToPadding = false
        sliderViewPager.adapter = sliderAdapter
        myHandler= Handler()
        myHandler.post { changeSliderPages() }
    }

    private fun changeSliderPages()
    {
        if (sliderAdapter.count == 0)
            return

        if (sliderIndex == sliderAdapter.count)
            sliderIndex = 0

         sliderViewPager.currentItem=sliderIndex++

        handlerRunnable= Runnable{
            changeSliderPages()
        }
         myHandler.postDelayed(handlerRunnable,4000)
    }

    override fun onDestroy() {
        super.onDestroy()
        myHandler.removeCallbacks(handlerRunnable)
    }


}

package com.app.roomy.view.fragment.landActivity


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.app.roomy.R
import com.app.roomy.adapter.HouseRecyclerAdapter
import com.app.roomy.view.uiConfig.BaseFragment
import kotlinx.android.synthetic.main.fragment_house.*

class HouseFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_house, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerHouses.layoutManager = LinearLayoutManager(fragmentContext, RecyclerView.VERTICAL, false)
        recyclerHouses.adapter = HouseRecyclerAdapter()
    }

}

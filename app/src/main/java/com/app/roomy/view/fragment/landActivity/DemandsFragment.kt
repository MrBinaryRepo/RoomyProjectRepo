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
import com.app.roomy.adapter.DemandsRecyclerAdapter
import com.app.roomy.view.uiConfig.BaseFragment
import kotlinx.android.synthetic.main.fragment_demands.*

class DemandsFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_demands, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindDemandRecycler()
    }

    private fun bindDemandRecycler() {
        recyclerDemands.layoutManager=LinearLayoutManager(fragmentContext,RecyclerView.VERTICAL,false)
        recyclerDemands.adapter=DemandsRecyclerAdapter()
    }
}

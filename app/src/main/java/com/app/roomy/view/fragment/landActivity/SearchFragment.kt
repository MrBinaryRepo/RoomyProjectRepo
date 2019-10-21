package com.app.roomy.view.fragment.landActivity


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.app.roomy.R
import com.app.roomy.adapter.HouseRecyclerAdapter
import com.app.roomy.view.uiConfig.BaseFragment
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : BaseFragment()
{
    private lateinit var houseAdapter:HouseRecyclerAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initEvents()
        setupHouseAdapterToRecyclerView()
    }

    private fun initEvents() {
        edtSearch.addTextChangedListener(object : TextWatcher
        {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int)
            {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int)
            {

            }

            override fun afterTextChanged(s: Editable)
            {
                if(s.length==2)
                    searchHouse()
            }
        })
    }

    private fun setupHouseAdapterToRecyclerView() {
        layoutManager= LinearLayoutManager(fragmentContext,RecyclerView.VERTICAL,false)
        houseAdapter= HouseRecyclerAdapter()
        recyclerSearchedHouses.layoutManager=layoutManager
        recyclerSearchedHouses.adapter=houseAdapter
    }

    private fun searchHouse() {

    }

}

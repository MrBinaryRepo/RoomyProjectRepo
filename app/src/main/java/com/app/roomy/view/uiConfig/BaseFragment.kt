package com.app.roomy.view.uiConfig

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

open class BaseFragment:Fragment()
{
    protected lateinit var fragmentContext :Context

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentContext=view.context
    }
}
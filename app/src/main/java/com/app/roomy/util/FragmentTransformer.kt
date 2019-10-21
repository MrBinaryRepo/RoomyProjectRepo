package com.app.roomy.util

import androidx.annotation.AnimRes
import androidx.annotation.AnimatorRes
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class FragmentTransformer {

    private var FragmentManagerInstance: FragmentManager? = null
    private var NewFragment: Fragment ?=null
    private var PlaceHolderId: Int = 0
    private var AnimIn = 0
    private var AnimOut = 0

    fun with(fragmentManager: FragmentManager): FragmentTransformer {
        FragmentManagerInstance = fragmentManager
        return this
    }

    fun replaceFragment(newFragment: Fragment): FragmentTransformer {
        NewFragment = newFragment
        return this
    }

    fun into(@IdRes placeHolder: Int): FragmentTransformer {
        PlaceHolderId = placeHolder
        return this
    }

    fun withAnimation(@AnimatorRes @AnimRes animIn: Int, @AnimatorRes @AnimRes animOut: Int): FragmentTransformer {
        AnimIn = animIn
        AnimOut = animOut
        return this
    }

    fun commit() {
        val ft = FragmentManagerInstance!!.beginTransaction()
        if (AnimIn == 0 || AnimOut == 0) {
            //ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        } else {
            ft.setCustomAnimations(AnimIn, AnimOut)
        }
        NewFragment?.let { ft.replace(PlaceHolderId, it) }
        ft.commit()
    }

    fun commit(ft: FragmentTransaction) {
        NewFragment?.let { ft.replace(PlaceHolderId, it) }
        ft.commitAllowingStateLoss()
    }

}

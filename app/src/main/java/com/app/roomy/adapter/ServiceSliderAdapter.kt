package com.app.roomy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.app.roomy.R
import com.bumptech.glide.Glide

class ServiceSliderAdapter() : PagerAdapter() {
    val imageList: MutableList<Int> = mutableListOf()

    init {
        imageList.add(R.drawable.img1)
        imageList.add(R.drawable.img2)
        imageList.add(R.drawable.img3)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var imgSlider = ImageView(container.context)
        imgSlider.scaleType=ImageView.ScaleType.FIT_XY

        Glide.with(container.context).load(imageList[position]).into(imgSlider)
        container.addView(imgSlider)
        return imgSlider

    }

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return view == o
    }

    override fun getCount(): Int {
        return imageList.size;
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View?)
    }
}
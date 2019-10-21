package com.app.roomy.view.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import com.app.roomy.R
import com.app.roomy.view.uiConfig.BaseActivity
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import android.view.animation.TranslateAnimation
import com.app.roomy.view.fragment.landActivity.*
import kotlinx.android.synthetic.main.activity_land.*
import kotlinx.android.synthetic.main.navigation_menu_layout.*


class LandActivity : BaseActivity() {

    var isMenuOpen:Boolean=false
   override fun onCreate(savedInstanceState: Bundle?)
   {
       super.onCreate(savedInstanceState)
       fullscreenActivity()
       setContentView(R.layout.activity_land)

       bindBottomMenu()

      /* btnNavigateMenu.setOnClickListener {
           if(!isMenuOpen)
           {
               navMenu.visibility=View.VISIBLE
               val animate = TranslateAnimation(
                   0f,
                   0f,
                   0f,
                   navMenu.height.toFloat()
               )
               animate.duration = 2000
               animate.fillAfter = true
               navMenu.startAnimation(animate)
           }
           else
           {
               navMenu.visibility=View.INVISIBLE
               val animate = TranslateAnimation(
                   0f,
                   0f,
                   navMenu.height.toFloat(),
                   0f
               )
               animate.duration = 2000
               animate.fillAfter = true
               navMenu.startAnimation(animate)
           }
           isMenuOpen = !isMenuOpen;
       }
*/
   }

    private fun bindBottomMenu()
    {
        bottomNavMenu.add(MeowBottomNavigation.Model(1, R.drawable.ic_profile))
        bottomNavMenu.add(MeowBottomNavigation.Model(2, R.drawable.ic_search))
        bottomNavMenu.add(MeowBottomNavigation.Model(3, R.drawable.ic_needs))
        bottomNavMenu.add(MeowBottomNavigation.Model(4, R.drawable.ic_service))
        bottomNavMenu.add(MeowBottomNavigation.Model(5, R.drawable.ic_home))
        bottomNavMenu.show(4,true)
        showFragment(HouseFragment(),R.id.landActivityPlaceHolder)
        bottomNavMenu.setOnClickMenuListener { menuItem->
            when(menuItem.id)
            {
                5->showFragment(HouseFragment(),R.id.landActivityPlaceHolder)
                4->showFragment(ServicesFragment(),R.id.landActivityPlaceHolder)
                3->showFragment(DemandsFragment(),R.id.landActivityPlaceHolder)
                2->showFragment(SearchFragment(),R.id.landActivityPlaceHolder)
               1->showFragment(ManageFragment(),R.id.landActivityPlaceHolder)
            }
        }
    }

}

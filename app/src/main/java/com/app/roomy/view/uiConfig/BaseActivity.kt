package com.app.roomy.view.uiConfig

import android.annotation.SuppressLint
import android.content.Context
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.app.roomy.util.FragmentTransformer
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity()
{
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    protected fun fullscreenActivity()
    {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    protected fun showFragment(targetFragment: Fragment, placeholderId:Int)
    {
        FragmentTransformer().with(supportFragmentManager).replaceFragment(targetFragment).into(placeholderId).commit()
    }
}
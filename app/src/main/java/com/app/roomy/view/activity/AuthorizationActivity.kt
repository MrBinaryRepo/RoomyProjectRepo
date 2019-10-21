package com.app.roomy.view.activity

import android.os.Bundle
import com.app.roomy.R
import com.app.roomy.util.FragmentTransformer
import com.app.roomy.view.fragment.authorizationActivity.AuthenticateFragment
import com.app.roomy.view.uiConfig.BaseActivity

class AuthorizationActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)
        showAuthenticateFragment()
    }

    private fun showAuthenticateFragment() {
        supportFragmentManager.let { it1 ->
            FragmentTransformer().with(it1).replaceFragment(AuthenticateFragment())
                .into(R.id.authorizationActivityPlaceholder).commit()
        }
    }
}

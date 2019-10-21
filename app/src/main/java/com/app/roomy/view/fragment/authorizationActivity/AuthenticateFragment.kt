package com.app.roomy.view.fragment.authorizationActivity


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.app.roomy.R
import com.app.roomy.util.FragmentTransformer
import kotlinx.android.synthetic.main.fragment_authenticate.*

class AuthenticateFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_authenticate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initEvents()
    }

   fun initEvents()
    {
        btnAuthorization.setOnClickListener {
            fragmentManager?.let { it1 -> FragmentTransformer().with(it1).replaceFragment(
                ActivationFragment()
            ).into(R.id.authorizationActivityPlaceholder).commit()}
        }
    }
}

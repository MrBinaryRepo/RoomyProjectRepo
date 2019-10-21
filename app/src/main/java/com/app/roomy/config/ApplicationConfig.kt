package com.app.roomy.config

import android.app.Application

import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class ApplicationConfig : Application()
{
    override fun onCreate() {
        super.onCreate()
        setApplicationFont()
    }

    private fun setApplicationFont()
    {
        CalligraphyConfig.initDefault(
            CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/iransans_light.ttf")
                .build()
        )
    }
}
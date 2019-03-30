package com.example.softballapp

import android.app.Application

class App: Application()
{
    override fun onCreate()
    {
        super.onCreate()
        ObjectBox.init(this)
    }
}
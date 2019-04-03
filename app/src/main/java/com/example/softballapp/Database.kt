package com.example.softballapp

import android.app.Application
import io.objectbox.Box

class Database:Application() {

    override fun onCreate() {
        super.onCreate()
        ObjectBox.init(this)

    }


}
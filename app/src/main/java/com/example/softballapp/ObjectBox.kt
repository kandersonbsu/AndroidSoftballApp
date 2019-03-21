package com.example.softballapp

import android.content.Context
import android.util.Log
import io.objectbox.BoxStore

/**
 * Singleton to keep BoxStore reference.
 */
object ObjectBox {

    lateinit var boxStore: BoxStore
        private set

    fun init(context: Context) {
        boxStore = MyObjectBox.builder().androidContext(context.applicationContext).build()

    }

}

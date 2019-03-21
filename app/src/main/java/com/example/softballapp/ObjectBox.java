package com.example.softballapp;
import android.content.Context;
import io.objectbox.BoxStore;
public class ObjectBox {

    private static BoxStore boxStore;
    public static void init(Context context)
    {
        boxStore = MyObjectBox.builder().androidContext(this).build();
        //test
    }
}

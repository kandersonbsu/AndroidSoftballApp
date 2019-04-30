package com.example.softballapp

import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToOne
import android.R.id
import android.support.annotation.IntegerRes
import io.objectbox.converter.PropertyConverter
import kotlin.reflect.KClass


@Entity
data class Player(@Id var id: Long = 0, var firstName: String, var lastName: String, var pos:String)
{
    constructor():this(id = 0, firstName = "", lastName = "", pos = "")
    var position:String = pos

    lateinit var team: ToOne<Team>


    fun getFullName():String
    {
        return firstName + " " + lastName
    }
}

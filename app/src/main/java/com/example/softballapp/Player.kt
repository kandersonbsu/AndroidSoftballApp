package com.example.softballapp

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToOne

@Entity
data class Player(@Id var id: Long = 0, var firstName: String, var lastName: String)
{
    lateinit var team: ToOne<Team>
}

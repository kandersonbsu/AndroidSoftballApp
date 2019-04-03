package com.example.softballapp

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class Team(var teamName: String, var manager: String, var location: String)
{
    @Id var id: Long = 0

    lateinit var players: MutableList<Player>


    fun AddPlayer(p: Player): Unit{
        players.add(p)
    }
}
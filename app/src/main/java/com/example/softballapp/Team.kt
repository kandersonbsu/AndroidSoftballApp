package com.example.softballapp

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class Team(var teamName: String)
{
    @Id var id: Long = 0

    lateinit var players: List<Player>
}
package com.example.softballapp

import io.objectbox.annotation.Backlink
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.relation.ToMany

@Entity
data class Team(var teamName: String, var manager: String, var location: String)
{
    constructor():this(teamName = "", manager = "", location = "")
    @Id var id: Long = 0

    @Backlink(to = "team")
    lateinit var players: MutableList<Player>
}
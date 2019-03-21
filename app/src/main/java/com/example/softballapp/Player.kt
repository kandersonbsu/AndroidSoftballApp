package com.example.softballapp

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
public class Player(@Id var id:Long, var firstName: String, var lastName: String, var position: Position)
{

}
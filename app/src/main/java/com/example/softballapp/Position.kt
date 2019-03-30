package com.example.softballapp

import io.objectbox.annotation.Entity


enum class Position(var shorthand: String)
{
    Catcher("C"),
    Pitcher("P"),
    FirstBase("1B"),
    SecondBase("2B"),
    ShortStop("SS"),
    ThirdBase("3B"),
    LeftField("LF"),
    LeftCenterField("LCF"),
    RightCenterField("RCF"),
    RightField("RF")


}
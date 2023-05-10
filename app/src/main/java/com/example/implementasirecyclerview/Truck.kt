package com.example.implementasirecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Truck (
    val name : String,
    val description : String,
    val photo : Int
) : Parcelable

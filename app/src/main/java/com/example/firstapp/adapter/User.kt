package com.example.firstapp.adapter

import android.os.Parcel
import android.os.Parcelable

data class User(
    val name:String,
    val image: String,
    val flag:Int?
)
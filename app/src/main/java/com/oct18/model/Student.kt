package com.oct18.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey
    val id:Int,

    @ColumnInfo(name = "first_name")
    val firstName:String,

    @ColumnInfo(name = "last_name")
    val lastName:String,

    val email:String,

    @Ignore var isSelected:Boolean=false
)

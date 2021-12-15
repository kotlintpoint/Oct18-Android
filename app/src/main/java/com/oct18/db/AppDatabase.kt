package com.oct18.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oct18.dao.StudentDao
import com.oct18.model.Student

@Database(entities = [Student::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun studentDao():StudentDao
}
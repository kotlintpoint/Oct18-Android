package com.oct18.db

import android.content.Context
import androidx.room.Room
import com.oct18.R

class DbUtils {

    companion object{
        fun getDatabase(context: Context) = Room.databaseBuilder(
                                                context,
                                                AppDatabase::class.java,
                                                context.getString(R.string.app_name)
                                            ).allowMainThreadQueries()
                                                .build()



    }
}
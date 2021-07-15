package com.hank.calileo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hank.calileo.dao.LevelDao
import com.hank.calileo.data.Level

@Database(entities = [Level::class],version = 1,exportSchema = false)
abstract class CalileoDatabase : RoomDatabase() {

    abstract fun levelDao() : LevelDao

    companion object{
        private var INSTANCE : CalileoDatabase? = null

        fun getDatabase(context: Context): CalileoDatabase{
            val tempInstance = INSTANCE
            if(null!=tempInstance){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CalileoDatabase::class.java,
                    "calileo_database").build()
                INSTANCE = instance
                return instance
            }

        }

    }
}
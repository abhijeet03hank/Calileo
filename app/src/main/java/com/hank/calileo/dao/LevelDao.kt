package com.hank.calileo.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hank.calileo.data.Level

@Dao
interface LevelDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLevel(level: Level)

    @Query("SELECT * FROM traning_level_table ORDER BY id ASC")
    fun getAllLevels():LiveData<List<Level>>
}
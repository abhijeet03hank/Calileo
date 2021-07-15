package com.hank.calileo.repository

import androidx.lifecycle.LiveData
import com.hank.calileo.dao.LevelDao
import com.hank.calileo.data.Level

class LevelRepository(private val levelDao: LevelDao) {
    val getAllLevels : LiveData<List<Level>> = levelDao.getAllLevels()

    suspend fun addLevel(level : Level){
        levelDao.addLevel(level)
    }
}
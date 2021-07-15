package com.hank.calileo.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hank.calileo.data.Level
import com.hank.calileo.db.CalileoDatabase
import com.hank.calileo.repository.LevelRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LevelViewModel(context: Context): ViewModel() {

    private val levelData : LiveData<List<Level>>
    private val levelRepository : LevelRepository

    init{
        val levelDao = CalileoDatabase.getDatabase(context).levelDao()
        levelRepository = LevelRepository(levelDao)
        levelData = levelRepository.getAllLevels
    }

    fun addLevel(level: Level){
        viewModelScope.launch (Dispatchers.IO){
            levelRepository.addLevel(level)
        }
    }
}
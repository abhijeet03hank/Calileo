package com.hank.calileo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "traning_level_table")
data class Level (
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val level_name : String,
    val totalProgram : Int,
    val completedPrograms : Int

)
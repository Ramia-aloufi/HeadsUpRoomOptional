package com.example.headsuproom_optional

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cliprte")
data class Celeprteis (
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "id")  var id : Int? = null, // this is how can include id if needed
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "tapoo1") val tapoo1: String,
    @ColumnInfo(name = "tapoo2") val tapoo2: String,
    @ColumnInfo(name = "tapoo3") val tapoo3: String
)
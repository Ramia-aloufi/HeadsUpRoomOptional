package com.example.headsuproom_optional

import androidx.room.*

@Dao
interface CeleprteisDao {

    @Query("SELECT * FROM Cliprte  ORDER BY id ASC")
    fun getAllUserInfo(): MutableList<Celeprteis>

    @Insert
    fun insertCeleprteis(celeprteis: Celeprteis)

    @Delete
    fun DeleteCeleprteis(celeprteis: Celeprteis)

    @Update
    fun UpdateCeleprteis(celeprteis: Celeprteis)

}
package com.example.headsuproom_optional

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Celeprteis::class],version = 1,exportSchema = false)
abstract class CeleprteisDatabase:RoomDatabase() {

    companion object{
        var instance:CeleprteisDatabase?=null;
        fun getInstance(ctx: Context):CeleprteisDatabase
        {
            if(instance!=null)
            {
                return  instance as CeleprteisDatabase;
            }
            instance= Room.databaseBuilder(ctx,CeleprteisDatabase::class.java,"raam11").run { allowMainThreadQueries() }.build();
            return instance as CeleprteisDatabase;
        }
    }
    abstract fun CeleprteisDao(): CeleprteisDao;
}
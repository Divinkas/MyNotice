package com.example.testing.divinkas.rm_kotlin.Model.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testing.divinkas.rm_kotlin.Model.Constants
import com.example.testing.divinkas.rm_kotlin.Model.Data.Notice

@Database(entities = [Notice::class], version = Constants.DATABASE_VERSION)
abstract class NoticeDatabase: RoomDatabase(){

    abstract fun notice_dao():NoticeDao

}
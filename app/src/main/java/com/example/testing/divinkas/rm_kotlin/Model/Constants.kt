package com.example.testing.divinkas.rm_kotlin.Model

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.testing.divinkas.rm_kotlin.Model.Room.NoticeDatabase

object Constants {
    //---  TABLE NOTICE  ---
    const val TABLE_NOTICE:String = "Notices"

    const val id_notice:String = "id"
    const val notice_text:String = "notice_text"
    const val notice_status:String = "notice_status"
    //---  1  ---
    const val DATABASE_VERSION:Int = 1
    const val DATABASE_NAME:String = "Notice_databases"



    //
    private var db_instance: NoticeDatabase? = null

    fun getInstanceDatabaseConnect(context: Context): NoticeDatabase {
        if(db_instance == null){
            db_instance = Room.databaseBuilder(context, NoticeDatabase::class.java, Constants.DATABASE_NAME).build()
        }
        return db_instance as NoticeDatabase
    }

}
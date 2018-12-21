package com.example.testing.divinkas.rm_kotlin.Model.Room

import androidx.room.*
import com.example.testing.divinkas.rm_kotlin.Model.Constants
import com.example.testing.divinkas.rm_kotlin.Model.Data.Notice
import io.reactivex.Flowable


@Dao
interface NoticeDao {
    @get:Query("select * from " + Constants.TABLE_NOTICE)
    val allNotices: Flowable<List<Notice>>

    //@Query("select * from " + Constants.TABLE_NOTICE)
    //fun getAllNotices(): Flowable<List<Notice>>

    @Query("select * from " + Constants.TABLE_NOTICE + " where " + Constants.id_notice + "=:noticeId")
    fun getNoticeById(noticeId:Int):Notice

    @Insert
    fun insertNotice(vararg newNotice:Notice)

    @Update
    fun updateNotice(vararg newNotice:Notice)

    @Delete
    fun deleteNotice(notice:Notice)

    @Query("Delete from " + Constants.TABLE_NOTICE + " where " + Constants.id_notice + " =:noticeId")
    fun deleteNoticeById(noticeId:Int)

}
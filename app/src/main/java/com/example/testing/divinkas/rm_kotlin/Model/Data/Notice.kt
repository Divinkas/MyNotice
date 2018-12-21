package com.example.testing.divinkas.rm_kotlin.Model.Data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testing.divinkas.rm_kotlin.Model.Constants
import io.reactivex.annotations.NonNull

@Entity(tableName = Constants.TABLE_NOTICE)
data class Notice constructor(
    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Constants.id_notice)
    var id:Int = 0,

    @ColumnInfo(name = Constants.notice_text)
    var text_notice:String? = null,

    @ColumnInfo(name = Constants.notice_status)
    var status_notice:Int = 0

)
package com.example.testing.divinkas.rm_kotlin.Presenter

import android.content.Context
import com.example.testing.divinkas.rm_kotlin.Model.Callback.RoomCallback
import com.example.testing.divinkas.rm_kotlin.Model.Data.Notice
import com.example.testing.divinkas.rm_kotlin.Model.DatabaseModel
import com.example.testing.divinkas.rm_kotlin.View.Contract.MainContract

open class MainPresenter: RoomCallback {

    private val context: Context
    private val databaseModel:DatabaseModel
    private var contract:MainContract

    constructor(context: Context, contract: MainContract){
        this.context = context
        this.contract = contract
        databaseModel = DatabaseModel(this.context)

    }

    fun load_notices() {
        databaseModel.load_notices(this)
    }

    fun add_notice(text:String){
        databaseModel.add_notice(text)
    }

    override fun set_list(list: List<Notice>) {
        if (list.isEmpty()){
            contract.init_data(ArrayList())
        } else {
            contract.init_data(list)
        }
    }

    fun update_notice(notice: Notice) {
        databaseModel.update(notice)
    }
    fun delete_notice(notice: Notice){
        databaseModel.delete(notice)
    }
}
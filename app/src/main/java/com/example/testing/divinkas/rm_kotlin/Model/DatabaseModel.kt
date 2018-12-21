package com.example.testing.divinkas.rm_kotlin.Model

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import com.example.testing.divinkas.rm_kotlin.Model.Callback.RoomCallback
import com.example.testing.divinkas.rm_kotlin.Model.Constants.getInstanceDatabaseConnect
import com.example.testing.divinkas.rm_kotlin.Model.Data.Notice
import com.example.testing.divinkas.rm_kotlin.Model.Room.NoticeDatabase
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


open class DatabaseModel {
    private var context: Context
    private var database: NoticeDatabase? = null

    constructor(_context: Context){
        this.context = _context
        database = getInstanceDatabaseConnect(this.context)
    }

    @SuppressLint("CheckResult")
    fun load_notices(callback: RoomCallback){
        Single.fromCallable {
            database?.notice_dao()!!.allNotices
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { callback.set_list(it) }
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }

    @SuppressLint("CheckResult")
    fun add_notice(text_notice:String){
        val notice= Notice(text_notice = text_notice, status_notice = 0)
        Single.fromCallable {
            database?.notice_dao()!!.insertNotice(notice)
        }.subscribeOn(Schedulers.io()).subscribe()
    }

    @SuppressLint("CheckResult")
    fun update(notice: Notice) {
        Single.fromCallable {
            database?.notice_dao()!!.updateNotice(notice)
        }.subscribeOn(Schedulers.io()).subscribe()
    }

    @SuppressLint("CheckResult")
    fun delete(notice: Notice) {
        Single.fromCallable {
            database?.notice_dao()!!.deleteNotice(notice)
        }.subscribeOn(Schedulers.io()).subscribe()
    }

    private fun old_method_adding(text:String){
        val notice= Notice(text_notice = text, status_notice = 0)
        val observer = object : Observer<Notice> {
            override fun onSubscribe(d: Disposable) {}
            override fun onNext(notice_item: Notice) {
                database?.notice_dao()!!.insertNotice(notice_item)
            }
            override fun onError(e: Throwable) {}
            override fun onComplete() {}
        }

        val observable = object : Observable<Notice>() {
            override fun subscribeActual(observer: Observer<in Notice>) {
                observer.onNext(notice)
            }
        }
        observable
            .subscribeOn(Schedulers.io())
            .subscribe(observer)

    }
}
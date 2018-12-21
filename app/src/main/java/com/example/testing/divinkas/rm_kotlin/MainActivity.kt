package com.example.testing.divinkas.rm_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.testing.divinkas.rm_kotlin.Model.Data.Notice
import com.example.testing.divinkas.rm_kotlin.Presenter.MainPresenter
import com.example.testing.divinkas.rm_kotlin.View.Adapter.NoticeAdapter
import com.example.testing.divinkas.rm_kotlin.View.Contract.MainContract
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract {

    private lateinit var presenter:MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this, this)
        presenter.load_notices()
        btn_add_new_notice.setOnClickListener {
            if(et_new_notice.text !=  null){
                presenter.add_notice(et_new_notice.text.toString())
                presenter.load_notices()
            }
        }
    }

    override fun init_data(list: List<Notice>) {
        rv_list_notices.layoutManager = LinearLayoutManager(this)
        rv_list_notices.adapter = NoticeAdapter(this, list, presenter)
    }
}

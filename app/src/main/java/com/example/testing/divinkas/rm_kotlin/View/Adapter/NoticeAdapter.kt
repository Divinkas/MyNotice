package com.example.testing.divinkas.rm_kotlin.View.Adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testing.divinkas.rm_kotlin.Model.Data.Notice
import com.example.testing.divinkas.rm_kotlin.Presenter.MainPresenter
import com.example.testing.divinkas.rm_kotlin.R


internal open class NoticeAdapter(private val context:Context, private var list: List<Notice>, private var presenter:MainPresenter) : RecyclerView.Adapter<NoticeAdapter.NoticeHolder>() {

    override fun onBindViewHolder(holder: NoticeHolder, position: Int) {
        holder.setIsRecyclable(false)
        holder.tv_text_notice.text = list[position].text_notice
        holder.ll_container.setOnClickListener {
            if(list[position].status_notice == 0){
                list[position].status_notice = 1
                presenter.update_notice(list[position])
            }else{
                list[position].status_notice = 0
                presenter.update_notice(list[position])
            }
            check(holder, position)
        }
        holder.img_dell.setOnClickListener {
            presenter.delete_notice(list[position])
            presenter.load_notices()
        }
        check(holder, position)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NoticeHolder {
        return NoticeHolder(LayoutInflater.from(context).inflate(R.layout.item_notice, p0, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    internal inner class NoticeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_text_notice: TextView = itemView.findViewById(R.id.tv_text_notice)
        var ll_container: LinearLayout = itemView.findViewById(R.id.ll_container_notice)
        var img_dell: ImageView = itemView.findViewById(R.id.img_dell_notice)
    }


    private fun check(holder: NoticeHolder, position: Int){
        if (list[position].status_notice == 0){
            holder.ll_container.setBackgroundColor(Color.WHITE)
            list[position].status_notice = 1
        } else {
            holder.ll_container.setBackgroundResource(R.color.col_light_gray)
            list[position].status_notice = 0
        }
    }

}
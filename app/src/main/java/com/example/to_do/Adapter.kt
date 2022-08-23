package com.example.to_do

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter (
    private val model: MutableList<Model>
) : RecyclerView.Adapter<Adapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val title: TextView = itemView.findViewById(R.id.text_title)
        val check: CheckBox = itemView.findViewById(R.id.cdDone)
    }

    //Press Ctrl+i

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list,
                parent,
                false
            )
        )
    }

    fun addTodo(todo :Model){
        model.add(todo)
        notifyItemInserted(model.size - 1)
    }


    fun deleteDone(){
      model.removeAll { todo ->
          todo.isChecked
      }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(title:TextView, isChecked: Boolean){
        if (isChecked){
            title.paintFlags = title.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            title.paintFlags = title.paintFlags or STRIKE_THRU_TEXT_FLAG.inv()
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val curTodo = model[position]
        holder.title.text = curTodo.title
        holder.check.isChecked= curTodo.isChecked
    }

    override fun getItemCount(): Int {
        return model.size
    }

}
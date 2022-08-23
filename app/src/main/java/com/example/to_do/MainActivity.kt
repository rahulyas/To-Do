package com.example.to_do

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var adapters: Adapter
    private lateinit var recycleview: RecyclerView
    private lateinit var add: Button
    private lateinit var delete:Button
    private lateinit var edit_text:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleview = findViewById(R.id.recycleview)
        add = findViewById(R.id.add)
        delete = findViewById(R.id.delete)
        edit_text = findViewById(R.id.edit_text)

        adapters = Adapter(mutableListOf())
        recycleview.adapter = adapters
        recycleview.layoutManager = LinearLayoutManager(this)

        add.setOnClickListener {
            var title = edit_text.text.toString()
            if(title.isNotEmpty()){
                val todo = Model(title)
                adapters.addTodo(todo)
                edit_text.text.clear()
            }
        }

        delete.setOnClickListener {
            adapters.deleteDone()
        }
    }
}
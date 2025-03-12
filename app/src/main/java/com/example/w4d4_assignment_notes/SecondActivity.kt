package com.example.w4d4_assignment_notes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class SecondActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TaskAdapter
    private val taskList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = TaskAdapter(taskList)
        recyclerView.adapter = adapter

        val receivedTasks = intent.getStringArrayListExtra("tasks_list")
        if (receivedTasks != null) {
            taskList.addAll(receivedTasks) // Append to list
            adapter.notifyDataSetChanged() // Refresh RecyclerView
        }

        val addTaskButton: Button = findViewById(R.id.addTaskButton)
        addTaskButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putStringArrayListExtra("tasks_list", ArrayList(taskList)) // Pass tasks back
            startActivity(intent)
        }
    }
}


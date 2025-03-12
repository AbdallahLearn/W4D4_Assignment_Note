package com.example.w4d4_assignment_notes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activtiy_first)

        val editText = findViewById<EditText>(R.id.send_text_id)
        val button = findViewById<Button>(R.id.button_text_id)

        button.setOnClickListener {
            val task = editText.text.toString()

            if (task.isNotEmpty()) {
                Log.d("MainActivity", "Task: $task") // Debugging log

                val previousTasks = intent.getStringArrayListExtra("tasks_list") ?: ArrayList()

                previousTasks.add(task) // Add new task to the list

                val intent = Intent(this, SecondActivity::class.java)
                intent.putStringArrayListExtra("tasks_list", previousTasks)
                startActivity(intent)
            } else {
                editText.error = "Task cannot be empty!"
            }
        }
    }
}


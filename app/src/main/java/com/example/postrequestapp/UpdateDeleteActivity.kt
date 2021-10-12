package com.example.postrequestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class UpdateDeleteActivity : AppCompatActivity() {

    lateinit var userIDEditText: EditText
    lateinit var userNameEditText: EditText
    lateinit var userLocationEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_delete)

        userIDEditText = findViewById(R.id.user_id_et)
        userNameEditText = findViewById(R.id.username_et)
        userLocationEditText = findViewById(R.id.user_location_et)

        val deleteButton = findViewById<Button>(R.id.delete_user_btn)
        deleteButton.setOnClickListener {

        }

        val updateButton = findViewById<Button>(R.id.update_user_btn)
        updateButton.setOnClickListener {

        }
    }

    private fun deleteUser(userItem: UserItem){
        TODO()
    }

    private fun updateUser(userItem: UserItem){
        TODO()
    }
}
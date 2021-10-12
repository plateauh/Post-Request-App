package com.example.postrequestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            deleteUser(userIDEditText.text.toString().toInt())
        }

        val updateButton = findViewById<Button>(R.id.update_user_btn)
        updateButton.setOnClickListener {
            updateUser(UserItem(
                    userLocationEditText.text.toString(),
                    userNameEditText.text.toString(),
                    userIDEditText.text.toString().toInt()
            ))
        }
    }

    private fun deleteUser(userId: Int){
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        apiInterface?.deleteUser(userId)?.enqueue(object: Callback<Void>{
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                Toast.makeText(this@UpdateDeleteActivity, "User deleted", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(this@UpdateDeleteActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun updateUser(userItem: UserItem){
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        apiInterface?.updateUser(userItem.pk, userItem)?.enqueue(object: Callback<UserItem>{
            override fun onResponse(call: Call<UserItem>, response: Response<UserItem>) {
                Toast.makeText(this@UpdateDeleteActivity, "User updated", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<UserItem>, t: Throwable) {
                Toast.makeText(this@UpdateDeleteActivity, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
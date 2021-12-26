package com.example.simplegetrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val showData= findViewById<TextView>(R.id.showData)


        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        apiInterface!!.getPeople()?.enqueue(object : Callback<People?> {

            override fun onResponse(call: Call<People?>, response: Response<People?>) {
                val people = response.body()!!
                for (name in people)
                    "${showData.text}\n${name.name}".also { showData.text = it }
            }

            override fun onFailure(call: Call<People?>, t: Throwable) {
                Log.d("Error",t.toString())
                call.cancel()
            }
        })
    }
}
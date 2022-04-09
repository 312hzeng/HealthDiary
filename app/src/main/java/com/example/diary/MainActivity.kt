package com.example.diary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery
import com.parse.ParseUser

//let user create a post
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        queryPosts()

        findViewById<Button>(R.id.btSubmit).setOnClickListener{
            val description = findViewById<EditText>(R.id.tvDescription).text.toString()
            val workouttime = findViewById<EditText>(R.id.etWorkOutTime).text.toString()
            val wakeuptime = findViewById<EditText>(R.id.etWakeUpName).text.toString()
            val sleeptime = findViewById<EditText>(R.id.etSleepTime).text.toString()
            val user = ParseUser.getCurrentUser()
            submitPost(description, user, wakeuptime, sleeptime, workouttime)
        }
    }

    private fun submitPost(description: String, user: ParseUser, wakeuptime: String, sleeptime: String, workouttime: String ) {
        val diary = HealthDiary()
        diary.setDescription(description)
        diary.setUser(user)
        diary.setWakeUpTime(wakeuptime)
        diary.setSleepTime(sleeptime)
        diary.setWorkOutTime(workouttime)
        diary.saveInBackground{ exception ->
            if(exception != null){
                Log.e(TAG, "error saving diary")
                exception.printStackTrace()
            }else {
                Log.i(TAG, "successfully saved diary")
            }
        }
    }

    fun queryPosts() {
        val query: ParseQuery<HealthDiary> = ParseQuery.getQuery(HealthDiary::class.java)
        //find all post objects
        query.include(HealthDiary.KEY_USER)
        query.addDescendingOrder("createdAt")
        query.findInBackground(object: FindCallback<HealthDiary> {
            override fun done(posts: MutableList<HealthDiary>?, e: ParseException?) {
                if(e != null){
                    Log.e(TAG, "error fetching post")
                }else{
                    if(posts != null){
                        for(post in posts){
                            Log.i(TAG, "Post: " + post.getDescription() + ", username: " + post.getUser())
                        }

                    }
                }

            }
        })
    }
    companion object{
        const val TAG = "MainActivity"
    }

}
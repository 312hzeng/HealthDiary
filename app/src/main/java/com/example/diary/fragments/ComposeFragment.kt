package com.example.diary.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.diary.HealthDiary
import com.example.diary.R
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery
import com.parse.ParseUser


class ComposeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_compose, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btSubmit).setOnClickListener{
            val description = view.findViewById<EditText>(R.id.tvDescription).text.toString()
            val workouttime = view.findViewById<EditText>(R.id.etWorkOutTime).text.toString()
            val wakeuptime = view.findViewById<EditText>(R.id.etWakeUpName).text.toString()
            val sleeptime = view.findViewById<EditText>(R.id.etSleepTime).text.toString()
            val user = ParseUser.getCurrentUser()
            submitPost(description, user, wakeuptime, sleeptime, workouttime)
        }

    }
    fun submitPost(description: String, user: ParseUser, wakeuptime: String, sleeptime: String, workouttime: String ) {
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
    companion object{
        const val TAG = "MainActivity"
    }
}
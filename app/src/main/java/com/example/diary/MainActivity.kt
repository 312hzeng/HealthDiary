package com.example.diary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.diary.fragments.ComposeFragment
import com.example.diary.fragments.FeedFragment
import com.example.diary.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery
import com.parse.ParseUser

//let user create a post
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragmentManager: FragmentManager = supportFragmentManager

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener{
                item ->
            var fragmentToShow: Fragment?= null
            when(item.itemId){
                R.id.action_home-> {
                    //nevigate to home screen
                    fragmentToShow = FeedFragment()

                }
                R.id.action_compose-> {
                    //nevigate to compose
                    fragmentToShow = ComposeFragment()
                }
                R.id.action_profile-> {
                    //nevigate to profile
                    fragmentToShow = ProfileFragment()
                }
            }
            if(fragmentToShow != null){
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragmentToShow).commit()

            }
            true
        }
        findViewById<BottomNavigationView>(R.id.bottom_navigation).selectedItemId = R.id.action_home
        }
    }






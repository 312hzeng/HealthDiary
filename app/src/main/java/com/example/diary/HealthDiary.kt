package com.example.diary

import com.parse.ParseClassName
import com.parse.ParseObject
import com.parse.ParseUser

@ParseClassName("Diary")
class HealthDiary : ParseObject(){
    fun getDescription(): String? {
        return getString(KEY_DESCRIPTION)
    }
    fun setDescription(description: String) {
        put(KEY_DESCRIPTION, description)
    }

    fun getWakeUpTime(): String? {
        return getString(KEY_WAKEUPTIME)
    }
    fun setWakeUpTime(wakeuptime: String) {
        put(KEY_WAKEUPTIME, wakeuptime)
    }

    fun getSleepTime(): String? {
        return getString(KEY_SLEEPTIME)
    }
    fun setSleepTime(sleeptime: String) {
        put(KEY_SLEEPTIME, sleeptime)
    }

    fun getWorkOutTime(): String? {
        return getString(KEY_WORKOUTTIME)
    }
    fun setWorkOutTime(workouttime: String) {
        put(KEY_WORKOUTTIME, workouttime)
    }

    fun getUser(): ParseUser?{
        return getParseUser(KEY_USER)
    }
    fun setUser(parseuser: ParseUser){
        put(KEY_USER, parseuser)
    }


    companion object {
        const val KEY_DESCRIPTION = "Description"
        const val KEY_WORKOUTTIME = "WorkOutTime"
        const val KEY_WAKEUPTIME = "WakeUpTime"
        const val KEY_SLEEPTIME = "SleepTime"
        const val KEY_USER = "user"

    }
}
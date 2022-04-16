package com.example.diary.fragments
import android.util.Log
import com.example.diary.HealthDiary
import com.example.diary.fragments.FeedFragment
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery
import com.parse.ParseUser

class ProfileFragment: FeedFragment() {

    override fun queryPosts(){
        val query: ParseQuery<HealthDiary> = ParseQuery.getQuery(HealthDiary::class.java)
        //find all post objects
        query.include(HealthDiary.KEY_USER)
        query.whereEqualTo(HealthDiary.KEY_USER, ParseUser.getCurrentUser())
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
                        allPosts.addAll(posts)
                        adapter.notifyDataSetChanged()
                    }
                }

            }
        })
    }
}
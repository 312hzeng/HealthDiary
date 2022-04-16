package com.example.diary.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.diary.HealthDiary
import com.example.diary.PostAdapter
import com.example.diary.R
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery


open class FeedFragment : Fragment() {

    lateinit var postRecyclerView: RecyclerView
    lateinit var adapter: PostAdapter
    var allPosts: MutableList<HealthDiary> = mutableListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        postRecyclerView = view.findViewById<RecyclerView>(R.id.postRecyclerView)
        adapter = PostAdapter(requireContext(), allPosts)
        postRecyclerView.adapter = adapter
        postRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        queryPosts()
    }

    open fun queryPosts() {
        val query: ParseQuery<HealthDiary> = ParseQuery.getQuery(HealthDiary::class.java)
        //find all post objects
        query.include(HealthDiary.KEY_USER)
        query.addDescendingOrder("createdAt")
        query.findInBackground(object: FindCallback<HealthDiary> {
            override fun done(posts: MutableList<HealthDiary>?, e: ParseException?) {
                if(e != null){
                    Log.e(ComposeFragment.TAG, "error fetching post")
                }else{
                    if(posts != null){
                        for(post in posts){
                            Log.i(ComposeFragment.TAG, "Post: " + post.getDescription() + ", username: " + post.getUser())
                        }
                        allPosts.addAll(posts)
                        adapter.notifyDataSetChanged()

                    }
                }

            }
        })
    }
    companion object{
        const val TAG = "FeedFragment"
    }

}
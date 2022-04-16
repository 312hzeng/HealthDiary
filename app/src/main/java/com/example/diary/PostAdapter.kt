package com.example.diary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(val context: Context, val posts: List<HealthDiary>):
    RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvUserName: TextView
        val tvWorkOutTime:TextView
        val tvWakeUpTime: TextView
        val tvSleepTime: TextView
        val tvDescription: TextView
        init{
            tvUserName = itemView.findViewById(R.id.tvUserName)
            tvWorkOutTime = itemView.findViewById(R.id.tvWorkOutTime)
            tvWakeUpTime = itemView.findViewById(R.id.tvWakeUpName)
            tvDescription = itemView.findViewById(R.id.tvDescription)
            tvSleepTime = itemView.findViewById(R.id.tvSleepTime)
        }
        fun bind(healthyDiary: HealthDiary){
            tvDescription.text = healthyDiary.getDescription()
            tvUserName.text = healthyDiary.getUser()?.username
            tvSleepTime.text = healthyDiary.getSleepTime()
            tvWakeUpTime.text = healthyDiary.getWakeUpTime()
            tvWorkOutTime.text = healthyDiary.getWorkOutTime()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts.get(position)
        holder.bind(post)
    }

    override fun getItemCount(): Int {
        return posts.size
    }
}


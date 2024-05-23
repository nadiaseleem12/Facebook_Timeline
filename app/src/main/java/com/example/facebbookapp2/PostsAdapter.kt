package com.example.facebbookapp2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.facebbookapp2.databinding.ItemPostBinding

class PostsAdapter(private val posts: List<Post>) : Adapter<PostsAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemPostBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        holder.binding.tvProfileName.text = post.author.name
        holder.binding.imvProfilePic.setImageResource(post.author.profilePic)
        holder.binding.tvPostTime.text = post.date
        holder.binding.tvPostContent.text = post.content
        holder.binding.imvPostPhoto.setImageResource(post.image)
    }
}

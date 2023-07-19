package com.example.kotlinstagram.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstagram.databinding.RecyclerRowBinding
import com.example.kotlinstagram.model.Post
import com.squareup.picasso.Picasso

class FeedRecyclerAdapter(val postList:ArrayList<Post>):RecyclerView.Adapter<FeedRecyclerAdapter.PostHolder>() {
    class PostHolder(val binding: RecyclerRowBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostHolder(binding)

    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
    holder.binding.usernameText.text = postList.get(position).email
        holder.binding.commentText.text = postList.get(position).comment
        Picasso.get().load(postList.get(position).downloadUrl).into(holder.binding.imageView2)
    }

    override fun getItemCount(): Int {
    return postList.size
    }
}
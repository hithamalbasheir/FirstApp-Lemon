package com.example.firstapplemon.Ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapplemon.Model.Post
import com.example.firstapplemon.databinding.ListRowBinding

class RecyclerAdapter(private val context: Context): RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    private var postList :List<Post> = listOf()
//    fun setList(postList: ArrayList<Post>){
//        this.postList = postList
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ListRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return postList.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.userID.text = postList.get(position).userId.toString()
        holder.title.text = postList.get(position).title
        holder.body.text = postList.get(position).body
    }
    fun updatePosts(postList: List<Post>) {
        this.postList = postList
        notifyDataSetChanged()
    }
    class MyViewHolder(private val itemBinding: ListRowBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        val userID = itemBinding.userID
        val title = itemBinding.title
        val body = itemBinding.body
       
    }
}


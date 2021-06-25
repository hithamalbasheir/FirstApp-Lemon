package com.example.firstapplemon.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapplemon.databinding.ListRowBinding
import com.example.firstapplemon.domain.models.Post

class RecyclerAdapter(private val context: Context): RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    private var postList = mutableListOf<Post>()

    private var onActionListener: ActionListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ListRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    fun setOnActionListener(listener: ActionListener){
        this.onActionListener = listener
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.userID.text = postList[position].userId.toString()
        holder.title.text = postList[position].title
        holder.body.text = postList[position].body

        holder.deleteButton.setOnClickListener { onActionListener?.onDeleteClicked(postList[position]) }
        holder.editButton.setOnClickListener { onActionListener?.onEditClicked(postList[position]) }
    }

    fun updatePosts(postList: List<Post>) {
        this.postList.clear()
        this.postList.addAll(postList)
        notifyDataSetChanged()
    }

    class MyViewHolder(private val itemBinding: ListRowBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        val userID = itemBinding.userID
        val title = itemBinding.title
        val body = itemBinding.body
        val editButton = itemBinding.editButton
        val deleteButton = itemBinding.deleteButton

    }

    interface ActionListener{
        fun onDeleteClicked(post: Post)
        fun onEditClicked(post: Post)
    }
}


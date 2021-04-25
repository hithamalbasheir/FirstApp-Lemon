package com.example.firstapplemon.Ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapplemon.Base.BaseActivity
import com.example.firstapplemon.R
import com.example.firstapplemon.DI.MainApplication
import com.example.firstapplemon.Model.Post
import com.example.firstapplemon.databinding.ActivityMainBinding
import com.example.firstapplemon.databinding.ListRowBinding
import com.google.android.material.animation.Positioning

class MainActivity : BaseActivity<PostsPresenter>(), PostView {
    private val recyclerAdapter =  RecyclerAdapter(this)
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)
        binding.recyclerView.adapter = recyclerAdapter
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        presenter.onViewCreated()
    }

    override fun instantiatePresenter(): PostsPresenter {
        return PostsPresenter(this)
    }

    override fun updatePosts(postList: List<Post>) {
        recyclerAdapter.updatePosts(postList)
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

}
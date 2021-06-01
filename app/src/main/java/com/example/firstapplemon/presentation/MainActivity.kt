package com.example.firstapplemon.presentation

//import com.example.firstapplemon.presentation.di.DaggerGetPostsComponent
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapplemon.base.BaseActivity
import com.example.firstapplemon.databinding.ActivityMainBinding
import com.example.firstapplemon.domain.models.Post
import javax.inject.Inject

class MainActivity : BaseActivity() {
    private val recyclerAdapter =  RecyclerAdapter(this)
    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var presenter: PostsPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)
        binding.recyclerView.adapter = recyclerAdapter
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        val injector: ApplicationComponent = DaggerApplicationComponent
//        injector.inject(this)
//        val injector: GetPostsComponent = DaggerGetPostsComponent.create()
//        injector.inject(this)
        presenter.getPosts()
    }


    override fun onDestroy() {
        super.onDestroy()
//        presenter.onDestroy()
    }

    fun updatePosts(posts: List<Post>) {
        recyclerAdapter.updatePosts(posts)
    }

    fun showError(error: Int) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

}
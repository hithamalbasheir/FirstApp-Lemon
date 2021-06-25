package com.example.firstapplemon.presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.firstapplemon.MyApplication
import com.example.firstapplemon.databinding.ActivityUpdatePostBinding
import com.example.firstapplemon.domain.models.Post
import com.example.firstapplemon.presentation.di.DaggerGetPostsComponent
import com.example.firstapplemon.presentation.di.GetPostsModule
import com.example.firstapplemon.presentation.update.NewPostView
import com.example.firstapplemon.presentation.update.NewPostsPresenter
import javax.inject.Inject

class UpdatePostActivity : AppCompatActivity(), NewPostView {
    lateinit var binding: ActivityUpdatePostBinding
    private lateinit var post: Post
    @Inject
    lateinit var newPostsPresenter: NewPostsPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdatePostBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        DaggerGetPostsComponent.builder()
            .getPostsModule(GetPostsModule())
            .appComponent((application as MyApplication).getAppComponent() )
            .build()
            .inject(this)
        newPostsPresenter.attachView(this)
        post = intent.getSerializableExtra("post") as Post
        binding.userIDEditText.setHint("User ID : ${post.userId}")
        binding.titleEditText.setHint("Title : ${post.title}")
        binding.bodyEditText.setHint("Body : ${post.body}")
        binding.updateButton.setOnClickListener {
            val intent = Intent().apply {
                val userID = binding.userIDEditText.text.toString()
                val title = binding.titleEditText.text.toString()
                val body = binding.bodyEditText.text.toString()
                post.userId =  if (userID.isNotEmpty()) userID.toInt() else post.userId
                post.title =  if (title.isNotEmpty()) title else post.title
                post.body =  if (body.isNotEmpty()) body else post.body
                newPostsPresenter.onUpdate(post)
                putExtra("post",post)
            }
            setResult(Activity.RESULT_OK)
            finish()
        }
    }

    override fun updatedSuccessfully() {
        Toast.makeText(this,"Post with title ${post.title} Updated Successfully",Toast.LENGTH_LONG).show()
    }

    override fun showError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}
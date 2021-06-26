package com.example.firstapplemon.presentation

//import com.example.firstapplemon.presentation.di.DaggerGetPostsComponent
import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapplemon.MyApplication
import com.example.firstapplemon.base.BaseActivity
import com.example.firstapplemon.databinding.ActivityMainBinding
import com.example.firstapplemon.domain.models.Post
import com.example.firstapplemon.presentation.di.DaggerGetPostsComponent
import com.example.firstapplemon.presentation.di.GetPostsModule
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import javax.inject.Inject

class MainActivity : BaseActivity() , PostsView{
    private val recyclerAdapter =  RecyclerAdapter(this)
    private  var pressedTime: Long = 0
    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var presenter: PostsPresenter
    val getContent = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result: ActivityResult ->
        if(result.resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "done baby", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view= binding.root
        setContentView(view)
        recyclerAdapter.setOnActionListener(object : RecyclerAdapter.ActionListener {
            override fun onDeleteClicked(post: Post) {
                MaterialAlertDialogBuilder(this@MainActivity)
                    .setTitle("blah blah")
                    .setMessage("jdljfslkjflkdsjf")
                    .setPositiveButton("Yes", object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface, p1: Int) {
                            presenter.onDelete(post)
                            dialog.dismiss()
                        }
                    })
                    .setNegativeButton("Nope", object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface, p1: Int) {
                            dialog.dismiss()
                        }
                    })
                    .show()
            }

            override fun onEditClicked(post: Post) {
                val intent = Intent(this@MainActivity, UpdatePostActivity::class.java)
                intent.putExtra("post", post)
                getContent.launch(intent)
            }
        })
        binding.fab.setOnClickListener {
            val intent = Intent(this, UpdatePostActivity::class.java)
            getContent.launch(intent)
        }
        binding.recyclerView.adapter = recyclerAdapter
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        DaggerGetPostsComponent.builder()
                .getPostsModule(GetPostsModule())
                .appComponent((application as MyApplication).getAppComponent())
                .build()
                .inject(this)
        presenter.attachView(this)
        presenter.getPosts()
    }

    override fun displayPosts(posts: List<Post>) {
        recyclerAdapter.updatePosts(posts)
    }

    override fun showError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun deleteSuccess() {
        Toast.makeText(this, "Deleted Successfully", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    fun updatePosts(posts: List<Post>) {
        recyclerAdapter.updatePosts(posts)
    }

    fun showError(error: Int) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }
    override fun onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
            finish()
        } else {
            Toast.makeText(baseContext, "Press back again to exit", Toast.LENGTH_SHORT).show()
        }
        pressedTime = System.currentTimeMillis()
    }

}


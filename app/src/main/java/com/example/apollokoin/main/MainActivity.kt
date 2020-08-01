package com.example.apollokoin.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.apollokoin.R
import com.example.apollokoin.entities.Post
import com.example.apollokoin.graphql.type.PostOrderBy
import kotlinx.android.synthetic.main.content_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    private val mainAdapter: MainAdapter =
        MainAdapter({ post ->
            onPostClickListener(post)
        })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        setupUi()
        subscribePosts()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onResume() {
        super.onResume()
        loadPosts()
    }

    private fun subscribePosts() = mainViewModel.posts.observe(this, Observer { posts ->
        when (val response = posts) {
            is MainViewModel.PostsViewState.Success -> {
                if (mainAdapter.itemCount == 0) {
                    mainAdapter.items = response.posts.toMutableList()
                }
            }
            is MainViewModel.PostsViewState.Error -> {
                if (mainAdapter.itemCount == 0) {
                    Toast.makeText(
                        this,
                        "Error cargando items",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    })

    private fun setupUi() {
        mainRecycler.apply {
            adapter = mainAdapter
        }
    }

    private fun loadPosts() {
        if (mainAdapter.itemCount == 0) {
            mainViewModel.getAllPosts(50, PostOrderBy.UPDATEDAT_DESC)
        }
    }

    private fun onPostClickListener(post: Post) {
        Toast.makeText(
            this,
            post.title,
            Toast.LENGTH_LONG
        ).show()
    }
}

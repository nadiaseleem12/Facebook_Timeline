package com.example.facebbookapp2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.facebbookapp2.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var postsAdapter: PostsAdapter
    private val posts = mutableListOf<Post>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecyclerView()

    }

    private fun setRecyclerView() {
        createPostsList()
        postsAdapter = PostsAdapter(posts)
        binding.rvPosts.apply {
            adapter = postsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun createPostsList() {

        for (i in 1..10) {

            posts.add(
                Post(
                    author = User("Nadia Seleem", R.drawable.user),
                    date = getCurrentDateTime().toString("yyyy/MM/dd HH:mm:ss"),
                    content = "This app is great! :)",
                    image = R.drawable.happy
                )
            )
            posts.add(
                Post(
                    author = User("Nadia Seleem", R.drawable.user),
                    date = getCurrentDateTime().toString("yyyy-MMM-dd HH:mm:ss"),
                    content = "This app is fantastic! :)",
                    image = R.drawable.excited
                )
            )
            posts.add(
                Post(
                    author = User("Nadia Seleem", R.drawable.user),
                    date = getCurrentDateTime().toString("yy-MMMM-dd hh:mm a"),
                    content = "This app is awesome! :)",
                    image = R.drawable.lovely
                )
            )

        }

    }


}

fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
    val formatter = SimpleDateFormat(format, locale)
    return formatter.format(this)
}

fun getCurrentDateTime(): Date {
    return Calendar.getInstance().time
}

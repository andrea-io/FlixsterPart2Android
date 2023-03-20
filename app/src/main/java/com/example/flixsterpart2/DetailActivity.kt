package com.example.flixsterpart2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var detailMovieImage: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var ratingTextView: TextView
    private lateinit var movieDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        detailMovieImage = findViewById(R.id.detailMovieImage)
        titleTextView = findViewById(R.id.detailmovieTitle)
        ratingTextView = findViewById(R.id.detailmovieRating)
        movieDescription = findViewById(R.id.detailmovieDescription)

        val movie = intent.getSerializableExtra(MOVIE_EXTRA) as Movie

        titleTextView.text = movie.title
        ratingTextView.text = movie.vote_average.toString()
        movieDescription.text = movie.description

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/" + movie.poster_path)
            .into(detailMovieImage)
    }
}
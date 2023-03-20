package com.example.flixsterpart2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

const val MOVIE_EXTRA = "MOVIE_EXTRA"
private const val TAG = "MovieAdapter"

class MovieRecyclerViewAdapter(private val context: Context, private val movies: List<Movie>) :
    RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount() = movies.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val mediaImageView = itemView.findViewById<ImageView>(R.id.movie_poster)
        private val titleTextView = itemView.findViewById<TextView>(R.id.movie_title)
        private val ratingTextView = itemView.findViewById<TextView>(R.id.movie_popularity)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(movie: Movie) {
            titleTextView.text = movie.title
            ratingTextView.text = movie.vote_average.toString()

            Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500/" + movie.poster_path)
                .into(mediaImageView)
        }

        override fun onClick(v: View?) {
            val movie = movies[absoluteAdapterPosition]

            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(MOVIE_EXTRA, movie)
            context.startActivity(intent)
        }
    }

}
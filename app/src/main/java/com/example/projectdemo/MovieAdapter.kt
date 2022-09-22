package com.example.recyclerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projectdemo.Movie
import com.example.projectdemo.MovieDetailedActivity
import com.example.projectdemo.R

class MovieAdapter(
    private val movieList: List<Movie>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        val textView: TextView = itemView.findViewById(R.id.movie_name)
        val moviePoster: ImageView = itemView.findViewById(R.id.movie_poster)
//        val movieImage : ImageView = itemView.findViewById(R.id.detailedMovieImage)

    }

    var onItemClick: ((Movie) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemMovieView =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(itemMovieView)

    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = movieList[position]


//        holder.moviePoster.setImageResource(currentMovie.movieImage)
        holder.textView.text = currentMovie.title

         Glide.with(holder.itemView).load(holder.IMAGE_BASE +currentMovie.poster )
            .into(holder.moviePoster)

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(currentMovie)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }


}
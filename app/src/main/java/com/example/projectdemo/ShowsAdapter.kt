package com.example.projectdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ShowsAdapter (
    private val movieList: List<Movie>
) : RecyclerView.Adapter<ShowsAdapter.ShowsViewHolder>() {

    class ShowsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        val textView: TextView = itemView.findViewById(R.id.movie_name)
        val moviePoster: ImageView = itemView.findViewById(R.id.movie_poster)

    }

    var onItemClick: ((Movie) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowsViewHolder {
        val itemMovieView =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ShowsViewHolder(itemMovieView)

    }

    override fun onBindViewHolder(holder: ShowsViewHolder, position: Int) {
        val currentMovie = movieList[position]
        holder.textView.text = currentMovie.showName

        Glide.with(holder.itemView).load(holder.IMAGE_BASE + currentMovie.poster)
            .into(holder.moviePoster)

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(currentMovie)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}
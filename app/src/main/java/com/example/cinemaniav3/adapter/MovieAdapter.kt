package com.example.cinemaniav3.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinemaniav3.R
import com.example.cinemaniav3.databinding.ItemMovieBinding
import com.example.cinemaniav3.model.Movie

class MovieAdapter(
    private val onMovieClick: (Movie) -> Unit // Callback for handling clicks
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val movies = mutableListOf<Movie>()

    fun submitList(newMovies: List<Movie>) {
        movies.clear()
        movies.addAll(newMovies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.
        from(parent.context), parent, false)
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(binding, view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position], onMovieClick)
    }
    override fun getItemCount(): Int = movies.size

    class MovieViewHolder(private val binding: ItemMovieBinding , itemView: View) : RecyclerView.ViewHolder(binding.root) {
//        private val movieImage: ImageView = itemView.findViewById(R.id.movieImage)
//        private val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
        fun bind(movie: Movie, onMovieClick: (Movie) -> Unit) {
            binding.title.text = movie.title
//            binding.overview.text = movie.overview
//            binding.rating.text = movie.vote_average.toString()

            Glide.with(binding.poster.context)
                .load("https://image.tmdb.org/t/p/w500${movie.poster_path}")
                .into(binding.poster)
            itemView.setOnClickListener { onMovieClick(movie) }
        }
    }
}
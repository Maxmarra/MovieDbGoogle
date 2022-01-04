package com.example.moviedbgoogle.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedbgoogle.databinding.GridViewItemBinding
import com.example.moviedbgoogle.network.MovieResponse

class MoviesGridAdapter : ListAdapter<MovieResponse.Movie,
        MoviesGridAdapter.MoviesViewHolder>(DiffCallback) {



    class MoviesViewHolder(private var binding:
                           GridViewItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MovieResponse.Movie) {
            binding.movie = movie
            binding.executePendingBindings()
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesGridAdapter.MoviesViewHolder {

        return MoviesViewHolder(GridViewItemBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(
        holder: MoviesGridAdapter.MoviesViewHolder,
        position: Int) {

        val movie = getItem(position)
        holder.bind(movie)
    }

    //Помогает не обновлять все фото при добавлении или удалении
    companion object DiffCallback : DiffUtil.ItemCallback<MovieResponse.Movie>() {

        override fun areItemsTheSame(
            oldItem: MovieResponse.Movie,
            newItem: MovieResponse.Movie
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: MovieResponse.Movie,
            newItem: MovieResponse.Movie
        ): Boolean {
            return oldItem.imgSrcUrl == newItem.imgSrcUrl
        }
    }
}
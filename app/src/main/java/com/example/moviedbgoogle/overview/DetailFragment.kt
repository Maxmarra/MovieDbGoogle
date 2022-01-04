package com.example.moviedbgoogle.overview

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.moviedbgoogle.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    companion object {
        const val MOVIE = "movie"

    }

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: DetailViewModel

    private lateinit var movie: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            movie = it.getString(MOVIE).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this

        val view = binding.root
        return view



    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.infoText.text = movie

    }


}
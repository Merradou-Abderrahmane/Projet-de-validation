package com.example.projet_validation.Ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.projet_validation.R
import com.example.projet_validation.Util.status
import com.example.projet_validation.databinding.FragmentAccueilBinding
import com.squareup.picasso.Picasso
import java.util.Observer

class AccueilFragment :BaseFragment<FragmentAccueilBinding>(FragmentAccueilBinding::inflate) {




    private val viewModel: ViewModel by viewModels()
    override fun init(view: View) {
        binding.apply {
            arguments.let {
                if (it != null) {
//                    filmID = it.getInt("idFilm",0)
                }
            }

        }


    }

    override fun listeners(view: View) {
        binding.apply {
        }
    }

}
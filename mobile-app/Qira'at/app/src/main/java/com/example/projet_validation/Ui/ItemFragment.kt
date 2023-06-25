package com.example.projet_validation.Ui

import android.media.MediaPlayer
import androidx.recyclerview.widget.GridLayoutManager
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projet_validation.Util.status
import com.example.projet_validation.databinding.FragmentItemListBinding

/**
 * A fragment representing a list of Items.
 */
class ItemFragment : BaseFragment<FragmentItemListBinding>(FragmentItemListBinding::inflate) {

    private val viewModel :ViewModel by viewModels()
    private lateinit var adapter: ItemAdapter
    lateinit var mediaPlayer: MediaPlayer

    companion object {
        var playingSurah: Int = 0
    }

    override fun init(view: View) {
        mediaPlayer = MediaPlayer()
        adapter = ItemAdapter(arrayListOf(),view.findNavController(), mediaPlayer)
        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapter
        }
        viewModel.getAll().observe(viewLifecycleOwner, Observer {
            when (it.status){
                status.ERROR-> this.showResponseError(it.message.toString())
                status.SUCCESS->{
                    binding.recyclerView.visibility = View.VISIBLE
                    adapter.apply {
                        addData(it.data!!)
                        notifyDataSetChanged()
                    }
                }
                else -> {
                    println("sssssssssss")
                }
            }
        })


    }

    override fun listeners(view: View) {

    }
}
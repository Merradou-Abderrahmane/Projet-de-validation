package com.example.projet_validation.Ui

import android.media.MediaPlayer
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.NavController
import com.example.projet_validation.Model.Surah
import com.example.projet_validation.R
import com.example.projet_validation.Repo.Repo

import com.example.projet_validation.Ui.placeholder.PlaceholderContent.PlaceholderItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class ItemAdapter(
    private val Surah: ArrayList<Surah>,
    navController: NavController,
    mediaPlayer: MediaPlayer
) : RecyclerView.Adapter<ItemAdapter.DataViewHolder>() {

    private val navController = navController
    private val mediaPlayer = mediaPlayer

    class DataViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val Title: TextView = view.findViewById<Button>(R.id.title)
        val btnSave: Button = view.findViewById<Button>(R.id.btnSave)
        val progressBar: ProgressBar = view.findViewById<ProgressBar>(R.id.progressBar)


        fun bind(surah: Surah) {
            Title.text = surah.name
            progressBar.visibility = if (surah.isPlaying) View.VISIBLE else View.INVISIBLE

//            Picasso.get().load("https://image.tmdb.org/t/p/w500/"+film.backdrop_path).into(imageFilm)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.DataViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return ItemAdapter.DataViewHolder(layout)
    }

    override fun getItemCount(): Int = Surah.size

    override fun onBindViewHolder(holder: ItemAdapter.DataViewHolder, position: Int) {
        val surah = Surah[position]
        holder.bind(surah)
        holder.btnSave.setOnClickListener {
            Log.d("TAG", surah.toString())
            CoroutineScope(Dispatchers.Main).launch {
                Repo().store(surah)
            }
            Toast.makeText(holder.itemView.context, "Surah added successfully", Toast.LENGTH_SHORT)
                .show()
        }

        holder.Title.setOnClickListener {
            val surahNumber = "00${surah.number}".takeLast(3)
            val audioUrl = "https://server11.mp3quran.net/a_ahmed/${surahNumber}.mp3"
            Log.d("Surah clicked", audioUrl)
            try {
                Toast.makeText(holder.itemView.context, "Playing...", Toast.LENGTH_SHORT).show()
                mediaPlayer.apply {
                    if (isPlaying) {
                        reset()
                        Surah[ItemFragment.playingSurah].isPlaying = false
                    }

                    if (ItemFragment.playingSurah == position) {
                        surah.isPlaying = false
                        ItemFragment.playingSurah = 0
                        notifyItemChanged(position)
                    } else {
                        setDataSource(audioUrl)
                        prepare()

                        // Show playing
                        surah.isPlaying = true
                        ItemFragment.playingSurah = position
                        notifyDataSetChanged()

                        // Start audio
                        start()

                        setOnCompletionListener {
                            reset()
                            surah.isPlaying = false
                            ItemFragment.playingSurah = 0
                            notifyItemChanged(position)
                        }
                    }


                }

            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("Audio Error", e.toString())
            }
        }


//            val action = FilmAvoirFragmentDirections.actionFilmAvoirFragmentToDetailFilmFragment(film.film_id)
//            navController.navigate(action)
        // }
        //  holder.btnDelete.setOnClickListener {


//            CoroutineScope(Dispatchers.Main).launch {
//
//                FilmRepo().delete(film.film_id)
//                // Success message
//                if (position != -1) {
//
//                    films.removeAt(position)
//                    notifyItemRemoved(position)
//                }
//                Toast.makeText(holder.itemView.context, "Film deleted successfully", Toast.LENGTH_SHORT).show()
//
//            }
        //   }
    }

    fun addData(surah: List<Surah>) {
        this.Surah.apply {
            clear()
            addAll(surah)
        }
    }
}
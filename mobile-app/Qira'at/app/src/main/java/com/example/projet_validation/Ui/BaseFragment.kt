package com.example.projet_validation.Ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

//typealias kat khalik t3ayet n ism whd li kayn fost parametre
typealias Inflater<T> = (inflater: LayoutInflater, view: ViewGroup?, attach: Boolean) -> T

abstract class BaseFragment<VB: ViewBinding>(private val inflater: Inflater<VB>) : Fragment() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!
    private var progressBar: ProgressBar? = null


    // for inflate layout fragment and create view for  fragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = this.inflater.invoke(inflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }
    //used to find views in the fragment's view and set up event listeners
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
        listeners(view)


    }
    //for events
    abstract fun listeners(view: View)
    // for find view
    abstract fun init(view: View)

    protected open fun observers() {}


    fun setProgressBar(resId: Int) {
        progressBar = view?.findViewById(resId)
    }

    fun showProgressBar() {
        progressBar?.visibility = View.VISIBLE
    }

    fun hideProgressBar() {
        progressBar?.visibility = View.INVISIBLE
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    protected open fun showResponseError(message : String){
        this.hideProgressBar()
        Log.d("tasks",message )
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

}


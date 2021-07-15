package com.hank.calileo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.hank.calileo.R
import kotlinx.android.synthetic.main.fragment_program.view.*


class ProgramFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_program, container, false)
        view.textview2.setOnClickListener { Navigation.findNavController(view).navigate(R.id.navigate_programFragment_to_trainingLevelFragment) }

        return  view
    }


}
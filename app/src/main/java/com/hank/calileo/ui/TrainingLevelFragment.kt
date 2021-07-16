package com.hank.calileo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.hank.calileo.R
import com.hank.calileo.adapter.LevelListAdapter
import com.hank.calileo.data.Level
import com.hank.calileo.viewmodel.LevelViewModel
import kotlinx.android.synthetic.main.fragment_training_level.view.*


class TrainingLevelFragment : Fragment() {

    private lateinit var mLevelViewModel: LevelViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_training_level, container, false)
//        view.goToPrograms.setOnClickListener { Navigation.findNavController(view).navigate(R.id.navigate_trainingLevelFragment_to_programFragment) }

        //viewModel
        mLevelViewModel = ViewModelProvider(this).get(LevelViewModel::class.java)

        //Adapter
        val adapter : LevelListAdapter = LevelListAdapter()

        //RecyclerView
        val recyclerView = view.level_recyclerview
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        mLevelViewModel.levelData.observe(viewLifecycleOwner, Observer {
            newlevelList -> adapter.setLevelData(newlevelList)
        })

        return view
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        view?.let{
            it.goToPrograms.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(R.id.navigate_trainingLevelFragment_to_programFragment)
            }

            it.addLevelsButton.setOnClickListener {
                addLevelsToDatabase()
            }
        }

    }

    override fun onStop() {
        super.onStop()
        view?.let {
            it.goToPrograms.setOnClickListener(null)
        }
    }

    private fun addLevelsToDatabase(){

        val level1 = Level(0,"Beginner",30,0)
        val level2 = Level(0,"Intermediate",40,0)
        val level3 = Level(0,"Advanced",50,0)

//        mLevelViewModel.addLevel(level1)
//        mLevelViewModel.addLevel(level2)
//        mLevelViewModel.addLevel(level3)
        var levelList = mutableListOf<Level>()
        levelList.add(level1)
        levelList.add(level2)
        levelList.add(level3)
        mLevelViewModel.addLevelList(levelList)

        Toast.makeText(requireContext(),"Training Levels added successfully!",Toast.LENGTH_SHORT).show()

    }


}
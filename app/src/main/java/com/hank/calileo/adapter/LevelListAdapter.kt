package com.hank.calileo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hank.calileo.R
import com.hank.calileo.data.Level
import kotlinx.android.synthetic.main.level_data_list.view.*

class LevelListAdapter: RecyclerView.Adapter<LevelListAdapter.MyViewHolder>() {

    private var levelList = emptyList<Level>()
    class MyViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.level_data_list,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentLevel = levelList[position]
        holder.itemView.level_name.text = currentLevel.level_name
        holder.itemView.total_programs.text = currentLevel.totalProgram.toString()
        holder.itemView.completed_programs.text = currentLevel.completedPrograms.toString()


    }

    override fun getItemCount(): Int {
        return levelList.size
    }

    fun setLevelData(newLevelList: List<Level>){
        this.levelList = newLevelList
        notifyDataSetChanged()
    }
}
package com.hank.calileo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.hank.calileo.R
import com.hank.calileo.databinding.ActivityCourseBinding
import kotlin.reflect.KProperty


class CourseActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private val courseBindingActivity : ActivityCourseBinding by lazy {
        ActivityCourseBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(courseBindingActivity.root)

        navController = Navigation.findNavController(this,R.id.fragmentContainerView)
        NavigationUI.setupActionBarWithNavController(this, navController)


    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,null)
    }

}



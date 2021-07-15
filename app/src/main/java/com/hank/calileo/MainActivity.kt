package com.hank.calileo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.hank.calileo.databinding.ActivityMainBinding
import com.hank.calileo.ui.CourseActivity

class MainActivity : AppCompatActivity() {

    private val mainActivityBinding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mainActivityBinding.root)

    }

    override fun onResume() {
        super.onResume()
        mainActivityBinding.startButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, CourseActivity::class.java)
            startActivity(intent)
        })
    }

    override fun onStart() {
        super.onStart()
    }

}
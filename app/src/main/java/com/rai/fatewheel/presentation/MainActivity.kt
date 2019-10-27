package com.rai.fatewheel.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.rai.fatewheel.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showProgress() {
        progressMain.visibility = View.VISIBLE
    }

    fun hideProgress() {
        progressMain.visibility = View.GONE
    }
}

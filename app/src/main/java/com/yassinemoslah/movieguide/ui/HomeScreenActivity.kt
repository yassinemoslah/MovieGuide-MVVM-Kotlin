package com.yassinemoslah.movieguide.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.yassinemoslah.movieguide.R
import com.yassinemoslah.movieguide.databinding.ActivityHomeScreenBinding

class HomeScreenActivity : AppCompatActivity() {

    private val homeScreenViewModel: HomeScreenViewModel by viewModels()
    private lateinit var binding: ActivityHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_screen)
        binding.apply {
            lifecycleOwner = this@HomeScreenActivity
            viewModel = homeScreenViewModel
        }
        
    }


}
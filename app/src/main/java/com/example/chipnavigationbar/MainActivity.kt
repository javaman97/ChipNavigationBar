package com.example.chipnavigationbar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.chipnavigationbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        // Does Stop from Going into Dark Mode

        setUpTabBar()
    }

    private fun setUpTabBar() {
        binding.chipNavigationBar.setOnItemSelectedListener{
            when(it){
                R.id.menu_home -> {
                    binding.textMain.text="Home"
                    binding.textMain.setTextColor(Color.BLUE)

                }
                R.id.menu_message ->{
                 binding.textMain.text="Message"
                    binding.textMain.setTextColor(Color.RED)

                }
                R.id.menu_profile -> {
                    binding.textMain.text="Profile"
                    binding.chipNavigationBar.showBadge(R.id.menu_settings)
                    binding.textMain.setTextColor(Color.MAGENTA)

                }
                R.id.menu_settings -> {
                    binding.textMain.text="Settings"
                    binding.chipNavigationBar.dismissBadge(R.id.menu_settings)
                    binding.textMain.setTextColor(Color.GREEN)

                }
            }
        }
    }

}
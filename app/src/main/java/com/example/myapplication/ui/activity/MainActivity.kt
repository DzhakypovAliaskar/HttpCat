package com.example.myapplication.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.doAfterTextChanged
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getImage()
        getCalculation()
    }

    private fun getCalculation() {
        binding.textEd.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                p0: CharSequence?,
                p1: Int,
                p2: Int,
                p3: Int
            ) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.numberTv.text = p0?.length.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    private fun getImage() {
        binding.textEd.doAfterTextChanged {
            Glide.with(binding.imageCat).load("https://http.cat/${binding.textEd.text}")
                .error(R.drawable.not_found)
                .into(binding.imageCat)
        }
    }
}

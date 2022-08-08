package com.geissonlucaso.businesscard.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.geissonlucaso.businesscard.App
import com.geissonlucaso.businesscard.R
import com.geissonlucaso.businesscard.data.BusinessCard
import com.geissonlucaso.businesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater)}

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {
        binding.btClose.setOnClickListener {
            finish()
        }

        binding.btConfirme.setOnClickListener {
            val businessCard = BusinessCard(
                name = binding.tilName.editText?.text.toString(),
                company = binding.tilCompany.editText?.text.toString(),
                phone = binding.tilPhone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                background = binding.tilColor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
package com.mcl.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.mcl.businesscard.App
import com.mcl.businesscard.R
import com.mcl.businesscard.data.BusinessCardEntity
import com.mcl.businesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater)}

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        insertListener()

    }

    private fun insertListener() {
        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnSave.setOnClickListener {
            val businessCard = BusinessCardEntity(
                name = binding.editName.text.toString(),
                company = binding.editCompany.text.toString(),
                phone = binding.editPhone.text.toString(),
                email = binding.editEmail.text.toString(),
                customBackground = binding.btnColor1.text.toString(),
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT ).show()
            finish()
        }
    }


}
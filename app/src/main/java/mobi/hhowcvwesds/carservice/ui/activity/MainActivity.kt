package mobi.hhowcvwesds.carservice.ui.activity

import android.os.Bundle
import mobi.hhowcvwesds.carservice.R
import mobi.hhowcvwesds.carservice.databinding.ActivityMainBinding
import mobi.hhowcvwesds.carservice.helpers.IntentHelper


class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpListeners()
    }

    private fun setUpListeners() {

        binding.btnAdd.setOnClickListener {
            insertCar()
        }

        binding.btnShowCarList.setOnClickListener {
            IntentHelper.navigateToCarList(this)
        }

    }

    private fun insertCar() {

        val carName = binding.etCarName.text.toString()
        val carNum = binding.etCarNumber.text.toString()
        val serviceDescription = binding.etServiceDescription.text.toString()

        if (carName.isNotEmpty() && carNum.isNotEmpty() && serviceDescription.isNotEmpty()) {
            viewModel.insertCar(carName, carNum, serviceDescription)
            binding.etCarName.text.clear()
            binding.etCarNumber.text.clear()
            binding.etServiceDescription.text.clear()
            showSnackBar(binding.root, getString(R.string.car_added))
        } else {
            showSnackBar(binding.root, getString(R.string.fill_the_form))
        }
    }
}
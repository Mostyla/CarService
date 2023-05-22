package mobi.hhowcvwesds.carservice.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import mobi.hhowcvwesds.carservice.R
import mobi.hhowcvwesds.carservice.database.AppDataBase
import mobi.hhowcvwesds.carservice.database.model.Car
import mobi.hhowcvwesds.carservice.databinding.ActivityMainBinding
import mobi.hhowcvwesds.carservice.viewmodel.AppViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val appDataBase: AppDataBase by inject()
    private val viewModel: AppViewModel by viewModel()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpListeners()
    }

    private fun setUpListeners() {

        binding.btnAdd.setOnClickListener {
            insertCar()
        }

        binding.btnShowCarList.setOnClickListener {
            startActivity(Intent(this@MainActivity, CarListActivity::class.java))
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
            Toast.makeText(this, getString(R.string.car_added), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, getString(R.string.fill_the_form), Toast.LENGTH_LONG).show()
        }
    }
}
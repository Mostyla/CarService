package mobi.hhowcvwesds.carservice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import mobi.hhowcvwesds.carservice.R
import mobi.hhowcvwesds.carservice.database.AppDataBase
import mobi.hhowcvwesds.carservice.databinding.ActivityCarListBinding
import mobi.hhowcvwesds.carservice.ui.adapter.CarListAdapter
import org.koin.android.ext.android.inject
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.delay
import mobi.hhowcvwesds.carservice.database.model.Car
import mobi.hhowcvwesds.carservice.viewmodel.AppViewModel

class CarListActivity : AppCompatActivity() {

    private val viewModel: AppViewModel by inject()

    private lateinit var binding: ActivityCarListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()

    }


    private fun setUpRecyclerView() {

        viewModel.getAllCars().observe(this) {
            binding.rcViewCars.adapter = CarListAdapter(it, viewModel)
            binding.rcViewCars.layoutManager = LinearLayoutManager(this@CarListActivity)
        }

    }
}
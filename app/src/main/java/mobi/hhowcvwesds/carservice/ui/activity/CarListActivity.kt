package mobi.hhowcvwesds.carservice.ui.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import mobi.hhowcvwesds.carservice.databinding.ActivityCarListBinding
import mobi.hhowcvwesds.carservice.ui.adapter.CarListAdapter


class CarListActivity : BaseActivity<ActivityCarListBinding>(ActivityCarListBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpRecyclerView()
    }


    private fun setUpRecyclerView() {

        viewModel.getAllCars().observe(this) {
            binding.rcViewCars.adapter = CarListAdapter(it, viewModel, this)
            binding.rcViewCars.layoutManager = LinearLayoutManager(this@CarListActivity)
        }

    }
}
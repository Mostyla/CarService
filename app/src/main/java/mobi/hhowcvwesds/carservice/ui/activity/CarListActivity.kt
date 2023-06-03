package mobi.hhowcvwesds.carservice.ui.activity

import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import mobi.hhowcvwesds.carservice.databinding.ActivityCarListBinding
import mobi.hhowcvwesds.carservice.ui.adapter.CarListAdapter
import mobi.hhowcvwesds.carservice.ui.adapter.holder.CarListHolder
import mobi.hhowcvwesds.carservice.ui.dialog.DialogUpdateCar


class CarListActivity : BaseActivity<ActivityCarListBinding>(ActivityCarListBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUpRecyclerView()

        initSearchDara()

        initClickListeners()
    }

    private fun initClickListeners() {
        binding.includeAppBar.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }


    private fun setUpRecyclerView() {
        binding.rcViewCars.layoutManager = LinearLayoutManager(this@CarListActivity)
        binding.rcViewCars.adapter = CarListAdapter().setOnClickListener { action, car ->
            when (action) {
                CarListHolder.CarHolderAction.OPEN -> {}
                CarListHolder.CarHolderAction.EDIT -> {
                    DialogUpdateCar(this, car, viewModel).show()
                }
                CarListHolder.CarHolderAction.DELETE -> {
                    viewModel.deleteCar(car)
                }
            }
        }
        viewModel.getAllCars().observe(this) {
            (binding.rcViewCars.adapter as? CarListAdapter)?.insertCars(it)
        }

    }

    private fun initSearchDara() {

        binding.includeAppBar.etSearch.doOnTextChanged { text, _, _, _ ->
            (binding.rcViewCars.adapter as? CarListAdapter)?.filterCars(text.toString())
        }

    }

}
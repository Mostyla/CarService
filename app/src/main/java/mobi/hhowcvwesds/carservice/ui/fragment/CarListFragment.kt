package mobi.hhowcvwesds.carservice.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import mobi.hhowcvwesds.carservice.databinding.FragmentCarListBinding
import mobi.hhowcvwesds.carservice.ui.adapter.CarListAdapter
import mobi.hhowcvwesds.carservice.ui.adapter.holder.CarListHolder
import mobi.hhowcvwesds.carservice.ui.dialog.DialogUpdateCar


class CarListFragment : BaseFragment<FragmentCarListBinding>(FragmentCarListBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

        initSearchDara()

        initClickListeners()

    }

    private fun initClickListeners() {
        binding.includeAppBar.btnBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }


    private fun setUpRecyclerView() {
        binding.rcViewCars.layoutManager = LinearLayoutManager(requireContext())
        binding.rcViewCars.adapter = CarListAdapter().setOnClickListener { action, car ->
            when (action) {
                CarListHolder.CarHolderAction.OPEN -> {}
                CarListHolder.CarHolderAction.EDIT -> {
                    DialogUpdateCar(requireActivity(), car, carRepo).show()
                }
                CarListHolder.CarHolderAction.DELETE -> {
                    carRepo.deleteCar(car)
                }
            }
        }
        carRepo.getAllCars().observe(requireActivity()) {
            (binding.rcViewCars.adapter as? CarListAdapter)?.insertCars(it)
        }

    }

    private fun initSearchDara() {

        binding.includeAppBar.etSearch.doOnTextChanged { text, _, _, _ ->
            (binding.rcViewCars.adapter as? CarListAdapter)?.filterCars(text.toString())
        }

    }

}
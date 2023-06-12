package mobi.hhowcvwesds.carservice.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import mobi.hhowcvwesds.carservice.R
import mobi.hhowcvwesds.carservice.databinding.FragmentRecordingBinding
import mobi.hhowcvwesds.carservice.helpers.IntentHelper


class RecordingFragment :
    BaseFragment<FragmentRecordingBinding>(FragmentRecordingBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpListeners()
    }

    private fun setUpListeners() {

        binding.btnAdd.setOnClickListener {
            insertCar()
        }

        binding.btnShowCarList.setOnClickListener {
            findNavController().navigate(R.id.action_recordingFragment_to_carListFragment)
        }

    }

    private fun insertCar() {

        val carName = binding.etCarName.text.toString()
        val carNum = binding.etCarNumber.text.toString()
        val serviceDescription = binding.etServiceDescription.text.toString()

        if (carName.isNotEmpty() && carNum.isNotEmpty() && serviceDescription.isNotEmpty()) {
            carRepo.insertCar(carName, carNum, serviceDescription)
            binding.etCarName.text.clear()
            binding.etCarNumber.text.clear()
            binding.etServiceDescription.text.clear()
            showSnackBar(binding.root, getString(R.string.car_added))
        } else {
            showSnackBar(binding.root, getString(R.string.fill_the_form))
        }
    }
}
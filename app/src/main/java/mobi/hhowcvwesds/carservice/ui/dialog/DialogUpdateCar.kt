package mobi.hhowcvwesds.carservice.ui.dialog

import android.app.Activity
import android.os.Bundle
import android.util.Log
import mobi.hhowcvwesds.carservice.database.model.Car
import mobi.hhowcvwesds.carservice.databinding.DialogUpdateCarBinding
import mobi.hhowcvwesds.carservice.viewmodel.AppViewModel


class DialogUpdateCar(
    private val activity: Activity,
    val car: Car,
    private val viewModel: AppViewModel
) :
    BaseDialog<DialogUpdateCarBinding>(DialogUpdateCarBinding::inflate, activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getAndUpdateDataFromRoom()
    }

    private fun getAndUpdateDataFromRoom() {

        binding.etCarName.setText(car.carName)
        binding.etCarNumber.setText(car.carNumber)
        binding.etServiceDescription.setText(car.serviceDescription)

        binding.btnUpdate.setOnClickListener {
            updateCar()
        }

        binding.closeArea.setOnClickListener {
            dismiss()
        }

        binding.btnClose.setOnClickListener {
            dismiss()
        }
    }

    private fun updateCar() {

        val carName = binding.etCarName.text.toString()
        val carNumber = binding.etCarNumber.text.toString()
        val carDescription = binding.etServiceDescription.text.toString()

        val updatedCar =
            Car(
                id = this.car.id,
                carName = carName,
                carNumber = carNumber,
                serviceDescription = carDescription
            )

        viewModel.updateCar(updatedCar)

        dismiss()

    }

}
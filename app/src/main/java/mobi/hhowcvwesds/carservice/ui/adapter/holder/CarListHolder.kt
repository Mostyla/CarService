package mobi.hhowcvwesds.carservice.ui.adapter.holder

import android.app.Activity
import android.util.Log
import androidx.lifecycle.asLiveData
import androidx.recyclerview.widget.RecyclerView
import mobi.hhowcvwesds.carservice.App
import mobi.hhowcvwesds.carservice.R
import mobi.hhowcvwesds.carservice.database.AppDataBase
import mobi.hhowcvwesds.carservice.database.model.Car
import mobi.hhowcvwesds.carservice.databinding.ServiceListItemBinding
import mobi.hhowcvwesds.carservice.ui.dialog.DialogUpdateCar
import mobi.hhowcvwesds.carservice.viewmodel.AppViewModel
import org.koin.android.ext.android.inject
import org.koin.java.KoinJavaComponent.inject

class CarListHolder(
    binding: ServiceListItemBinding,
    private val viewModel: AppViewModel,
    private val activity: Activity
) : RecyclerView.ViewHolder(binding.root) {

    private val imgService = binding.imgService
    private var tvCarName = binding.txtCarName
    private var tvCarNum = binding.txtCarNum
    private var tvServiceDescription = binding.txtServiceDescription
    private var btnDelete = binding.btnDelete
    private var btnEdit = binding.btnEdit

    fun bind(car: Car) {
        imgService.setImageResource(R.drawable.img_service)
        tvCarName.text = car.carName
        tvCarNum.text = car.carNumber
        tvServiceDescription.text = car.serviceDescription
        btnDelete.setOnClickListener {
            viewModel.deleteCar(car)
        }
        btnEdit.setOnClickListener {
            DialogUpdateCar(activity, car, viewModel).show()
        }

    }


}
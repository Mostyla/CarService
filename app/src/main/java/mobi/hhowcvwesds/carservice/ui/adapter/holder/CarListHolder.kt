package mobi.hhowcvwesds.carservice.ui.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import mobi.hhowcvwesds.carservice.R
import mobi.hhowcvwesds.carservice.database.model.Car
import mobi.hhowcvwesds.carservice.databinding.ServiceListItemBinding

class CarListHolder(
    binding: ServiceListItemBinding,
    private val onClickListener: ((CarHolderAction, Car) -> Unit)? = null
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
            onClickListener?.invoke(CarHolderAction.DELETE, car)
        }
        btnEdit.setOnClickListener {
            onClickListener?.invoke(CarHolderAction.EDIT, car)
        }
    }

    enum class CarHolderAction {
        OPEN, EDIT, DELETE
    }


}
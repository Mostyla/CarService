package mobi.hhowcvwesds.carservice.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mobi.hhowcvwesds.carservice.database.model.Car
import mobi.hhowcvwesds.carservice.databinding.ServiceListItemBinding
import mobi.hhowcvwesds.carservice.ui.adapter.holder.CarListHolder

class CarListAdapter() :
    RecyclerView.Adapter<CarListHolder>() {

    private var cars: ArrayList<Car> = ArrayList()
    private var filteredCars: ArrayList<Car> = ArrayList(cars)
    private var onClickListener: ((CarListHolder.CarHolderAction, Car) -> Unit)? = null

    fun setOnClickListener(onClickListener: (CarListHolder.CarHolderAction, Car) -> Unit) = this.also {
        this.onClickListener = onClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListHolder =
        CarListHolder(
            ServiceListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onClickListener
        )

    override fun onBindViewHolder(holder: CarListHolder, position: Int) {
        holder.bind(filteredCars[position])
    }

    override fun getItemCount(): Int = filteredCars.count()


    @SuppressLint("NotifyDataSetChanged")
    fun insertCars(cars: List<Car>) {
        this.cars.addAll(cars)
        this.filteredCars.addAll(cars)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun filterCars(query: String) {
        filteredCars.clear()
        for (car in cars) {
            if (car.carName.lowercase().startsWith(query)) {
                filteredCars.add(car)
            }
        }
        notifyDataSetChanged()
    }
}
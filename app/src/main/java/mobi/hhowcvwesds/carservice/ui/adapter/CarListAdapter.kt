package mobi.hhowcvwesds.carservice.ui.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mobi.hhowcvwesds.carservice.database.model.Car
import mobi.hhowcvwesds.carservice.databinding.ServiceListItemBinding
import mobi.hhowcvwesds.carservice.ui.adapter.holder.CarListHolder
import mobi.hhowcvwesds.carservice.viewmodel.AppViewModel

class CarListAdapter(
    private val cars: List<Car>,
    private val viewModel: AppViewModel,
    private val activity: Activity
) :
    RecyclerView.Adapter<CarListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListHolder =
        CarListHolder(
            ServiceListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            viewModel,
            activity
        )

    override fun onBindViewHolder(holder: CarListHolder, position: Int) {
        holder.bind(cars[position])
    }

    override fun getItemCount(): Int = cars.count()
}
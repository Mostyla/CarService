package mobi.hhowcvwesds.carservice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import mobi.hhowcvwesds.carservice.database.AppDataBase
import mobi.hhowcvwesds.carservice.database.model.Car

class AppViewModel(private val appDataBase: AppDataBase): ViewModel() {

    private val scope = CoroutineScope(Dispatchers.IO)

    fun insertCar(carName: String, carNumber: String, serviceDescription: String){
        val car = Car(carName, carNumber, serviceDescription)
        scope.launch {
            appDataBase.carDao().insert(car)
        }
    }

    fun deleteCar(car: Car){
        appDataBase.carDao().deleteCar(car)
    }

    fun getAllCars() = appDataBase.carDao().getAllCarsFlow().asLiveData()

}
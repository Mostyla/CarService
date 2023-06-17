package mobi.hhowcvwesds.carservice.repository

import androidx.lifecycle.asLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import mobi.hhowcvwesds.carservice.database.AppDataBase
import mobi.hhowcvwesds.carservice.database.model.Car

class CarRepo(private val appDataBase: AppDataBase){

    private val viewModelScope = CoroutineScope(Dispatchers.IO)

    fun insertCar(carName: String, carNumber: String, serviceDescription: String){
        val car = Car(carName = carName, carNumber = carNumber, serviceDescription = serviceDescription)
        viewModelScope.launch {
            appDataBase.carDao().insert(car)
        }
    }

    fun deleteCar(car: Car){
        viewModelScope.launch {
            appDataBase.carDao().deleteCar(car)
        }
    }

    fun getAllCars() = appDataBase.carDao().getAllCarsFlow().asLiveData()

    fun updateCar(car: Car) {
        viewModelScope.launch {
            appDataBase.carDao().updateCar(car)

        }
    }
}
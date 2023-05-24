package mobi.hhowcvwesds.carservice.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import mobi.hhowcvwesds.carservice.database.model.Car

@Dao
interface CarDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(car: Car)

    @Query("SELECT * FROM ${Car.TABLE_NAME}")
    fun getAllCarsFlow(): Flow<List<Car>>

    @Delete
    fun deleteCar(car: Car): Int

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCar(car: Car)

}
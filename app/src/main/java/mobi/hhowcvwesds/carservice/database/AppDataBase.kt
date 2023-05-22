package mobi.hhowcvwesds.carservice.database

import androidx.room.Database
import androidx.room.RoomDatabase
import mobi.hhowcvwesds.carservice.database.model.Car

private const val DATABASE_VERSION = 1

@Database(
    entities = [Car::class], version = DATABASE_VERSION
)

abstract class AppDataBase: RoomDatabase() {

    abstract fun carDao(): CarDao

}
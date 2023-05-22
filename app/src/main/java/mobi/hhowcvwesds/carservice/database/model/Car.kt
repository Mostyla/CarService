package mobi.hhowcvwesds.carservice.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import mobi.hhowcvwesds.carservice.database.model.Car.Companion.TABLE_NAME

@Entity(
    tableName = TABLE_NAME
)
data class Car(
    @PrimaryKey
    val carName: String,
    val carNumber: String,
    val serviceDescription: String
) {
    companion object {
        const val TABLE_NAME = "CAR"
    }
}

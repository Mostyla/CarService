package mobi.hhowcvwesds.carservice.di

import androidx.room.Room
import mobi.hhowcvwesds.carservice.App
import mobi.hhowcvwesds.carservice.database.AppDataBase
import mobi.hhowcvwesds.carservice.viewmodel.AppViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private const val DATABASE_NAME = "CarService.db"


val databaseModule = module {
    single {
        Room.databaseBuilder(androidApplication(), AppDataBase::class.java, DATABASE_NAME)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
    viewModel { //TODO: Разделить DB DI и основной модуль приложения
        AppViewModel(App().appDataBase)
    }
}

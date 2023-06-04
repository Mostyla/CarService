package mobi.hhowcvwesds.carservice.di

import mobi.hhowcvwesds.carservice.App
import mobi.hhowcvwesds.carservice.repository.CarRepo
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        CarRepo(App().appDataBase)
    }
}
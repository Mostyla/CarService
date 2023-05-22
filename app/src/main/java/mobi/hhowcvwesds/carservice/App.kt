package mobi.hhowcvwesds.carservice

import android.app.Application
import mobi.hhowcvwesds.carservice.database.AppDataBase
import mobi.hhowcvwesds.carservice.di.databaseModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    val appDataBase: AppDataBase by inject()

    override fun onCreate() {
        super.onCreate()
        
        diInit()
    }

    private fun diInit() {
        startKoin {
            androidContext(this@App)
            modules(
                databaseModule
            )
        }
    }
}
package mobi.hhowcvwesds.carservice.helpers

import android.app.Activity
import android.content.Intent
import mobi.hhowcvwesds.carservice.ui.activity.CarListActivity

object IntentHelper {

    fun navigateToCarList(activity: Activity){
        activity.startActivity(Intent(activity,CarListActivity::class.java))
    }
}
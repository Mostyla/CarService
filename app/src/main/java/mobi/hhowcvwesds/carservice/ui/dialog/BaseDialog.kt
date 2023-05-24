package mobi.hhowcvwesds.carservice.ui.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

abstract class BaseDialog<ViewBind : ViewBinding>(
    val bindingFactory: (LayoutInflater) -> ViewBind,
    activity: Activity
) : Dialog(activity, android.R.style.Theme_Translucent_NoTitleBar) {


    lateinit var binding: ViewBind

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

}
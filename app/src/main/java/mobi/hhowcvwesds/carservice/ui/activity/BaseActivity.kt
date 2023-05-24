package mobi.hhowcvwesds.carservice.ui.activity

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import mobi.hhowcvwesds.carservice.viewmodel.AppViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

abstract class BaseActivity<ViewBind : ViewBinding>(
    val bindingFactory: (LayoutInflater) -> ViewBind,
) : AppCompatActivity() {


    lateinit var binding: ViewBind
    val viewModel: AppViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
    }

    fun showSnackBar(view: View, snackText: String) {
        Snackbar.make(view,snackText, Snackbar.LENGTH_SHORT).show()
    }

}
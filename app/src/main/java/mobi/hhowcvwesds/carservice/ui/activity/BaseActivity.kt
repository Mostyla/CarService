package mobi.hhowcvwesds.carservice.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import mobi.hhowcvwesds.carservice.repository.CarRepo
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

abstract class BaseActivity<ViewBind : ViewBinding>(
    val bindingFactory: (LayoutInflater) -> ViewBind,
) : AppCompatActivity() {


    lateinit var binding: ViewBind
    val carRepo: CarRepo by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingFactory(layoutInflater)
        setContentView(binding.root)
    }

    fun showSnackBar(view: View, snackText: String) {
        Snackbar.make(view,snackText, Snackbar.LENGTH_SHORT).show()
    }

}
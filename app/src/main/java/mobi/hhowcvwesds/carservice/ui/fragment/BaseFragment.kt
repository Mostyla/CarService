package mobi.hhowcvwesds.carservice.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import mobi.hhowcvwesds.carservice.repository.CarRepo
import org.koin.android.ext.android.inject

abstract class BaseFragment<ViewBind : ViewBinding>(val bindingFactory: (LayoutInflater, ViewGroup?, Boolean) -> ViewBind) :
    Fragment() {

    lateinit var binding: ViewBind
    val carRepo: CarRepo by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = bindingFactory(layoutInflater, container, false)
        return binding.root
    }

    fun showSnackBar(view: View, snackText: String) {
        Snackbar.make(view,snackText, Snackbar.LENGTH_SHORT).show()
    }

}
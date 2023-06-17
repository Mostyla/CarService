package mobi.hhowcvwesds.carservice.ui.fragment

import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mobi.hhowcvwesds.carservice.R
import mobi.hhowcvwesds.carservice.databinding.FragmentSplashBinding


class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    private val scope = CoroutineScope(Dispatchers.Main)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setSplashAnimation()
        navigateToMainScreen()
    }

    private fun setSplashAnimation() {
        val carAnimation =
            AnimationUtils.loadAnimation(requireContext(), R.anim.right_slide_animation)
        binding.imgCar.startAnimation(carAnimation)
    }

    private fun navigateToMainScreen() {
        scope.launch {
            delay(3000)
            findNavController().navigate(R.id.action_splash_screen_to_onboardingFragment)
        }
    }


}
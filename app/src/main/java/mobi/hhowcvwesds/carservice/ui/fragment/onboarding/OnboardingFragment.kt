package mobi.hhowcvwesds.carservice.ui.fragment.onboarding

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import mobi.hhowcvwesds.carservice.R
import mobi.hhowcvwesds.carservice.databinding.FragmentOnboardingBinding
import mobi.hhowcvwesds.carservice.ui.fragment.BaseFragment
import mobi.hhowcvwesds.carservice.ui.fragment.onboarding.adapter.OnboardingAdapter
import mobi.hhowcvwesds.carservice.ui.fragment.onboarding.model.OnboardingScreen
import mobi.hhowcvwesds.carservice.utils.canMoveNext
import mobi.hhowcvwesds.carservice.utils.nextPage


class OnboardingFragment :
    BaseFragment<FragmentOnboardingBinding>(FragmentOnboardingBinding::inflate) {

    private val onboardingScreens by lazy {
        listOf(
            OnboardingScreen.OnboardingFirstScreen,
            OnboardingScreen.OnboardingSecondScreen,
            OnboardingScreen.OnboardingThirdScreen,
            OnboardingScreen.OnboardingFourthScreen
        )
    }

    private val onboardingDescriptionList by lazy {
        listOf(
            getString(R.string.onboarding_description_first),
            getString(R.string.onboarding_description_second),
            getString(R.string.onboarding_description_third),
            getString(R.string.onboarding_description_fourth)
        )
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupOnboardingViewPager()
        setupListeners()

    }

    private fun setupOnboardingViewPager() {
        binding.viewPagerOnboarding.adapter = OnboardingAdapter(onboardingScreens)
        binding.dotsIndicator.attachTo(binding.viewPagerOnboarding)
        binding.viewPagerOnboarding.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> {
                        binding.txtOnboardDescription.text = onboardingDescriptionList[0]
                    }
                    1 -> {
                        binding.txtOnboardDescription.text = onboardingDescriptionList[1]
                    }
                    2 -> {
                        binding.txtOnboardDescription.text = onboardingDescriptionList[2]
                    }
                    3 -> {
                        binding.txtOnboardDescription.text = onboardingDescriptionList[3]
                    }
                }
            }
        })

    }

    private fun setupListeners() {
        binding.btnGetStarted.setOnClickListener {
            if (binding.viewPagerOnboarding.canMoveNext())
                binding.viewPagerOnboarding.nextPage()
            else
                findNavController().navigate(R.id.action_onboardingFragment_to_recordingFragment)
        }

        binding.btnSkip.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment_to_recordingFragment)
        }

        binding.txtOnboardDescription.movementMethod = ScrollingMovementMethod()
    }
}
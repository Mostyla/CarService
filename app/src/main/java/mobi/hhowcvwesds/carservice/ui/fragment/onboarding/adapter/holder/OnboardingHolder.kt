package mobi.hhowcvwesds.carservice.ui.fragment.onboarding.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import mobi.hhowcvwesds.carservice.databinding.ItemOnboardingBinding
import mobi.hhowcvwesds.carservice.ui.fragment.onboarding.model.OnboardingScreen

class OnboardingHolder(binding: ItemOnboardingBinding) : RecyclerView.ViewHolder(binding.root) {

    private val imgContent = binding.imgOnboarding

    fun bind(onboardingScreen: OnboardingScreen) {
        imgContent.setImageResource(onboardingScreen.image)
    }

}
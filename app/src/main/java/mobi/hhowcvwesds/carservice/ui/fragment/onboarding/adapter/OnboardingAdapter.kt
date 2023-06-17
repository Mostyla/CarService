package mobi.hhowcvwesds.carservice.ui.fragment.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mobi.hhowcvwesds.carservice.databinding.ItemOnboardingBinding
import mobi.hhowcvwesds.carservice.ui.fragment.onboarding.adapter.holder.OnboardingHolder
import mobi.hhowcvwesds.carservice.ui.fragment.onboarding.model.OnboardingScreen

class OnboardingAdapter(private val onboardingScreens: List<OnboardingScreen>) :
    RecyclerView.Adapter<OnboardingHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingHolder =
        OnboardingHolder(
            ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = onboardingScreens.count()

    override fun onBindViewHolder(holder: OnboardingHolder, position: Int) {
        holder.bind(onboardingScreens[position])
    }

}
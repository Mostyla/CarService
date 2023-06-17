package mobi.hhowcvwesds.carservice.ui.fragment.onboarding.model

import androidx.annotation.DrawableRes
import mobi.hhowcvwesds.carservice.R

sealed class OnboardingScreen(

    @DrawableRes val image: Int
) {

    object OnboardingFirstScreen : OnboardingScreen(
        image = R.drawable.img_onboarding_1
    )

    object OnboardingSecondScreen : OnboardingScreen(
        image = R.drawable.img_onboarding_2
    )

    object OnboardingThirdScreen : OnboardingScreen(
        image = R.drawable.img_onboarding_3
    )

    object OnboardingFourthScreen : OnboardingScreen(
        image = R.drawable.img_onboarding_4
    )

}
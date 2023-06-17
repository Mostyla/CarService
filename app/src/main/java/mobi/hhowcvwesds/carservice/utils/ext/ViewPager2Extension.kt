package mobi.hhowcvwesds.carservice.utils.ext

import androidx.viewpager2.widget.ViewPager2

enum class ViewPagerScrollMode {
    DEFAULT, INFINITY
}

fun ViewPager2.nextPage(
    scrollMode: ViewPagerScrollMode = ViewPagerScrollMode.DEFAULT
) {
    when (scrollMode) {
        ViewPagerScrollMode.INFINITY -> {
            if (this.canMoveNext())
                this.currentItem += 1
            else
                this.currentItem = 0
        }
        else -> {
            if (this.canMoveNext())
                this.currentItem += 1
        }
    }
}

fun ViewPager2.previousPage(
    scrollMode: ViewPagerScrollMode = ViewPagerScrollMode.DEFAULT
) {
    val maxIndex = this.adapter?.itemCount ?: 0

    when (scrollMode) {
        ViewPagerScrollMode.INFINITY -> {
            if (this.canMovePrevious())
                this.currentItem -= 1
            else
                this.currentItem = maxIndex
        }
        else -> {
            if (this.canMovePrevious())
                this.currentItem -= 1
        }
    }
}

fun ViewPager2.canMoveNext(): Boolean {
    val maxIndex = (this.adapter?.itemCount?.minus(1)) ?: 0
    val currentIndex = this.currentItem
    return currentIndex < maxIndex
}

fun ViewPager2.canMovePrevious(): Boolean {
    val currentIndex = this.currentItem
    return currentIndex > 0
}



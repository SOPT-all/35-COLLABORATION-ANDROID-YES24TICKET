package org.andsopt.android.yes24ticket.presentation.type

import androidx.annotation.StringRes
import org.andsopt.android.yes24ticket.R

enum class FilterType(
    @StringRes val filter: Int,
    val id: String,
) {
    POPULAR(
        filter = R.string.category_detail_filter_popularity,
        id = "popular",
    ),
    RATING(
        filter = R.string.category_detail_filter_ranking,
        id = "rating",
    ),
    REVIEWS(
        filter = R.string.category_detail_filter_reviews,
        id = "reviews",
    ),
    ENDING(
        filter = R.string.category_detail_filter_end,
        id = "ending",
    ),
}

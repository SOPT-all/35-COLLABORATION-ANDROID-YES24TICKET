package org.andsopt.android.yes24ticket.presentation.type

import androidx.annotation.StringRes
import org.andsopt.android.yes24ticket.R

enum class HomeCategoryType(
    @StringRes val category: Int
) {
    CONCERT(
        category = R.string.home_category_type_concert
    ),
    MUSICAL(
        category = R.string.home_category_type_musical
    ),
    PLAY(
        category = R.string.home_category_type_play
    ),
    CLASSIC_DANCE(
        category = R.string.home_category_type_classic_dance
    ),
    EXHIBITION_EVENT(
        category = R.string.home_category_type_exhibition_event
    ),
    FAMILY_CHILDREN(
        category = R.string.home_category_type_family_children
    )
}

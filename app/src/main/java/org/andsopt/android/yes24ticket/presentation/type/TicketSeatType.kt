package org.andsopt.android.yes24ticket.presentation.type

import androidx.annotation.DrawableRes
import org.andsopt.android.yes24ticket.R

enum class TicketSeatType (
    val typeId: Int,
    @DrawableRes val seatIcon: Int,
){
    VIOLET(
        typeId = 1,
        seatIcon = R.drawable.ic_ticket_detail_sit_violet_10
    ),
    MINT(
        typeId = 2,
        seatIcon = R.drawable.ic_ticket_detail_sit_mint_10
    ),
    BLUE(
        typeId = 3,
        seatIcon = R.drawable.ic_ticket_detail_sit_blue_10
    ),
    YELLOW(
        typeId = 4,
        seatIcon = R.drawable.ic_ticket_detail_sit_yellow_10
    );

    companion object {
        fun fromTypeId(typeId: String): TicketSeatType? {
            return entries.find { it.typeId == typeId.toInt() }
        }
    }
}
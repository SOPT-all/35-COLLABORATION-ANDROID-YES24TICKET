package org.andsopt.android.yes24ticket.domain.model

data class TicketDetailEntity (
    val ticketId: String,
    val ticketTitle: String,
    val ticketGenre: String = "콘서트",
    val ticketArea: String,
    val ticketImg: String,
    val ticketDate: String,
    val ticketDuration: String,
    val ticketAge: String,
    val ticketLikedCount: String,
    val ticketHyperText: String,
    val ticketNotice: List<String>,
    val ticketPerformanceTimes: List<String>,
    val ticketPricing: List<TicketPricingEntity>
)
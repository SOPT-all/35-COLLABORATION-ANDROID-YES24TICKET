package org.andsopt.android.yes24ticket.domain.model

data class WhatsHotEntity(
    val id: Long,
    val title: String,
    val area: String,
    val date: String,
    val imgUrl: String,
    val comment: String? = "",
)

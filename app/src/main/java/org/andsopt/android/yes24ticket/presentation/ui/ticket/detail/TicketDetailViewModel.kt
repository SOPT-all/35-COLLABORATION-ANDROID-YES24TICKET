package org.andsopt.android.yes24ticket.presentation.ui.ticket.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.andsopt.android.yes24ticket.domain.model.TicketDetailEntity
import org.andsopt.android.yes24ticket.domain.model.TicketPricingEntity
import javax.inject.Inject

@HiltViewModel
class TicketDetailViewModel
@Inject
constructor() : ViewModel() {

    val mockData = TicketDetailEntity(
        ticketId = "21",
        ticketTitle = "김창옥 토크콘서트",
        ticketArea = "영남대 천마아트센터",
        ticketImg = "http://tkfile.yes24.com/upload2/PerfBlog/202409/20240906/20240906-50930.jpg",
        ticketDate = "2024.11.10 ~ 2024.11.10",
        ticketDuration = "총 160분",
        ticketAge = "만 7세 이상",
        ticketHyperText = "HYPE UP FESTIVAL 바로가기",
        ticketLikedCount = "163",
        ticketNotice = listOf("※ 본 공연은 네이버 쿠폰이 적용되지 않습니다.", "※ 본 공연은 YES24공연에서 진행하는 할인쿠폰이벤트 대상에서 제외됩니다.", "※ 매수제한: 공연별 1인 4매"),
        ticketPerformanceTimes = listOf("2024-11-20 (수) 13:00", "2024-11-21 (목) 15:00", "2024-11-22 (금) 14:00", "2024-11-23 (토) 15:00"),
        ticketPricing = listOf(
            TicketPricingEntity(
                type = "R석",
                price = "88,000원",
                color = "2"
            ),
            TicketPricingEntity(
                type = "S석",
                price = "77,000원",
                color = "3"
            ),
        )
    )
}
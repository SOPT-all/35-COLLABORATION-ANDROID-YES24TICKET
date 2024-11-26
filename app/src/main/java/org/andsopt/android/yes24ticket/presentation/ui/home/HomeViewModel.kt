package org.andsopt.android.yes24ticket.presentation.ui.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.andsopt.android.yes24ticket.domain.model.AdBannerEntity
import org.andsopt.android.yes24ticket.domain.model.LiveTicketRankingEntity
import org.andsopt.android.yes24ticket.domain.model.MainBannerEntity
import org.andsopt.android.yes24ticket.domain.model.WhatsHotEntity
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject
    constructor() : ViewModel() {
        val dummyBannerItems =
            listOf(
                MainBannerEntity(
                    id = 1,
                    imgUrl = "http://tkfile.yes24.com/Upload2/Display/202411/20241122/wel_mv_youthculture.jpg/dims/quality/70/",
                    title = "뮤지컬 시지프스",
                    area = "예스24스테이지 2관",
                    date = "2024. 12 - 2025. 03",
                ),
                MainBannerEntity(
                    id = 2,
                    imgUrl = "http://tkfile.yes24.com/Upload2/Display/202409/20240910/wel_mv_50929.jpg/dims/quality/70/",
                    title = "오페라의 유령",
                    area = "예스24스테이지 1관",
                    date = "2024. 10 - 2024. 12",
                ),
                MainBannerEntity(
                    id = 3,
                    imgUrl = "http://tkfile.yes24.com/Upload2/Display/202411/20241115/wel_mv_51725_e6e6e4.png/dims/quality/70/",
                    title = "레미제라블",
                    area = "예스24스테이지 3관",
                    date = "2025. 01 - 2025. 03",
                ),
                MainBannerEntity(
                    id = 4,
                    imgUrl = "http://tkfile.yes24.com/Upload2/Display/202410/20241014/wel_mv_51251.png/dims/quality/70/",
                    title = "햄릿",
                    area = "예스24스테이지 4관",
                    date = "2024. 11 - 2025. 02",
                ),
                MainBannerEntity(
                    id = 5,
                    imgUrl = "http://tkfile.yes24.com/Upload2/Display/202411/20241115/wel_mv_51615_2_1.png/dims/quality/70/",
                    title = "킹키부츠",
                    area = "예스24스테이지 5관",
                    date = "2024. 09 - 2024. 12",
                ),
            )

        val categoryList = listOf("콘서트", "뮤지컬", "연극", "클래식/무용", "전시/행사", "가족/어린이")

        val dummyRankingList =
            listOf(
                LiveTicketRankingEntity(
                    id = 1,
                    rank = 1,
                    imgUrl = "http://tkfile.yes24.com/upload2/perfblog/202410/20241029/20241029-51466.jpg/dims/quality/70/",
                ),
                LiveTicketRankingEntity(
                    id = 2,
                    rank = 2,
                    imgUrl = "http://tkfile.yes24.com/upload2/perfblog/202409/20240905/20240905-50929.jpg/dims/quality/70/",
                ),
                LiveTicketRankingEntity(
                    id = 3,
                    rank = 3,
                    imgUrl = "http://tkfile.yes24.com/upload2/perfblog/202411/20241118/20241118-50610.jpg/dims/quality/70/",
                ),
                LiveTicketRankingEntity(
                    id = 4,
                    rank = 4,
                    imgUrl = "http://tkfile.yes24.com/upload2/perfblog/202410/20241024/20241024-51251.jpg",
                ),
                LiveTicketRankingEntity(
                    id = 5,
                    rank = 5,
                    imgUrl = "http://tkfile.yes24.com/upload2/perfblog/202411/20241120/20241120-51786.jpg",
                ),
            )

        val dummyAdBannerList =
            listOf(
                AdBannerEntity(
                    id = 1,
                    imgUrl = "http://tkfile.yes24.com/Upload2/Display/202410/20241021/wel_wide_51324.png/dims/quality/70/",
                ),
                AdBannerEntity(
                    id = 2,
                    imgUrl = "http://tkfile.yes24.com/Upload2/Display/202411/20241115/wel_wide_51618_0a112c.png/dims/quality/70/",
                ),
                AdBannerEntity(
                    id = 3,
                    imgUrl = "http://tkfile.yes24.com/Upload2/Display/202410/20241021/wel_wide_51251_2.png/dims/quality/70/",
                ),
                AdBannerEntity(
                    id = 4,
                    imgUrl = "http://tkfile.yes24.com/Upload2/Display/202410/20241011/wel_wide_51249.png/dims/quality/70/",
                ),
                AdBannerEntity(
                    id = 5,
                    imgUrl = "http://tkfile.yes24.com/Upload2/Display/202411/20241122/wel_wide_51753.png/dims/quality/70/",
                ),
            )

        val dummyWhatsHotItems =
            listOf(
                WhatsHotEntity(
                    id = 1,
                    imgUrl = "http://tkfile.yes24.com/upload2/perfblog/202411/20241101/20241101-51565.jpg/dims/quality/70/",
                    title = "뮤지컬 시지프스",
                    area = "예스24스테이지 2관",
                    date = "2024. 12 - 2025. 03",
                    comment = "안녕",
                ),
                WhatsHotEntity(
                    id = 2,
                    imgUrl = "http://tkfile.yes24.com/upload2/perfblog/202411/20241120/20241120-51791.jpg/dims/quality/70/",
                    title = "오페라의 유령",
                    area = "예스24스테이지 1관",
                    date = "2024. 10 - 2024. 12",
                    comment = "안녕",
                ),
                WhatsHotEntity(
                    id = 3,
                    imgUrl = "http://tkfile.yes24.com/upload2/perfblog/202411/20241113/20241113-51709.jpg/dims/quality/70/",
                    title = "레미제라블",
                    area = "예스24스테이지 3관",
                    date = "2025. 01 - 2025. 03",
                ),
                WhatsHotEntity(
                    id = 4,
                    imgUrl = "http://tkfile.yes24.com/upload2/perfblog/202410/20241014/20241014-51331_1.jpg/dims/quality/70/",
                    title = "햄릿",
                    area = "예스24스테이지 4관",
                    date = "2024. 11 - 2025. 02",
                ),
                WhatsHotEntity(
                    id = 5,
                    imgUrl = "http://tkfile.yes24.com/upload2/perfblog/202411/20241107/20241107-51641.jpg/dims/quality/70/",
                    title = "킹키부츠",
                    area = "예스24스테이지 5관",
                    date = "2024. 09 - 2024. 12",
                ),
            )
    }

package org.andsopt.android.yes24ticket.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.andsopt.android.yes24ticket.R

val Typography =
    Typography(
        bodyLarge =
            TextStyle(
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.5.sp,
            ),
    )

val AppleSanDolGothicBold = FontFamily(Font(R.font.apple_sd_gothic_neo_bold))
val AppleSanDolGothicExtraBold = FontFamily(Font(R.font.apple_sd_gothic_neo_extrabold))
val AppleSanDolGothicMedium = FontFamily(Font(R.font.apple_sd_gothic_neo_medium))
val AppleSanDolGothicRegular = FontFamily(Font(R.font.apple_sd_gothic_neo_regular))
val AppleSanDolGothicSemiBold = FontFamily(Font(R.font.apple_sd_gothic_neo_semibold))

@Immutable
data class Yes24TicketTypography(
    // Head
    val headBold36: TextStyle,
    val headExtraBold24: TextStyle,
    val headExtraBold20: TextStyle,
    val headExtraBold17: TextStyle,
    val headBold15: TextStyle,
    // Title
    val titleSemiBold22: TextStyle,
    val titleSemiBold20: TextStyle,
    val titleExtraBold17: TextStyle,
    val titleBold15: TextStyle,
    val titleBold13: TextStyle,
    val titleExtraBold12: TextStyle,
    val titleBold12: TextStyle,
    val titleRegular12: TextStyle,
    // Body
    val bodyMedium24: TextStyle,
    val bodyBold14: TextStyle,
    val bodyBold13: TextStyle,
    val bodyRegular13: TextStyle,
    val bodyMedium13: TextStyle,
    val bodyBold12: TextStyle,
    val bodySemiBold12: TextStyle,
    val bodyRegular12: TextStyle,
    // Button
    val buttonExtraBold18: TextStyle,
    val buttonSemiBold19: TextStyle,
    val buttonBold14: TextStyle,
    val buttonBold13: TextStyle,
    val buttonRegular13: TextStyle,
    // Caption
    val captionExtraBold12: TextStyle,
    val captionBold12: TextStyle,
    val captionRegular11: TextStyle,
    val captionMedium11: TextStyle,
    val captionSemiBold10: TextStyle,
    val captionBold10: TextStyle,
    val captionRegular10: TextStyle,
)

val defaultYes24TicketTypography =
    Yes24TicketTypography(
        // Head
        headBold36 =
            TextStyle(
                fontFamily = AppleSanDolGothicBold,
                fontSize = 36.sp,
                lineHeight = 43.sp,
                letterSpacing = 0.sp,
            ),
        headExtraBold24 =
            TextStyle(
                fontFamily = AppleSanDolGothicExtraBold,
                fontSize = 24.sp,
                lineHeight = 29.sp,
                letterSpacing = 0.048.sp,
            ),
        headExtraBold20 =
            TextStyle(
                fontFamily = AppleSanDolGothicExtraBold,
                fontSize = 20.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.sp,
            ),
        headExtraBold17 =
            TextStyle(
                fontFamily = AppleSanDolGothicExtraBold,
                fontSize = 17.sp,
                lineHeight = 17.sp,
                letterSpacing = 0.sp,
            ),
        headBold15 =
            TextStyle(
                fontFamily = AppleSanDolGothicBold,
                fontSize = 15.sp,
                lineHeight = 18.sp,
                letterSpacing = 0.sp,
            ),
        // Title
        titleSemiBold22 =
            TextStyle(
                fontFamily = AppleSanDolGothicSemiBold,
                fontSize = 22.sp,
                lineHeight = 17.sp,
                letterSpacing = 0.sp,
            ),
        titleSemiBold20 =
            TextStyle(
                fontFamily = AppleSanDolGothicSemiBold,
                fontSize = 20.sp,
                lineHeight = 17.sp,
                letterSpacing = 0.sp,
            ),
        titleExtraBold17 =
            TextStyle(
                fontFamily = AppleSanDolGothicExtraBold,
                fontSize = 17.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.sp,
            ),
        titleBold15 =
            TextStyle(
                fontFamily = AppleSanDolGothicBold,
                fontSize = 15.sp,
                lineHeight = 18.sp,
                letterSpacing = 0.sp,
            ),
        titleBold13 =
            TextStyle(
                fontFamily = AppleSanDolGothicBold,
                fontSize = 13.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.sp,
            ),
        titleExtraBold12 =
            TextStyle(
                fontFamily = AppleSanDolGothicExtraBold,
                fontSize = 12.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.12.sp,
            ),
        titleBold12 =
            TextStyle(
                fontFamily = AppleSanDolGothicBold,
                fontSize = 12.sp,
                lineHeight = 17.sp,
                letterSpacing = (-0.25).sp,
            ),
        titleRegular12 =
            TextStyle(
                fontFamily = AppleSanDolGothicRegular,
                fontSize = 12.sp,
                lineHeight = 14.sp,
                letterSpacing = 0.sp,
            ),
        // Body
        bodyMedium24 =
            TextStyle(
                fontFamily = AppleSanDolGothicMedium,
                fontSize = 24.sp,
                lineHeight = 17.sp,
                letterSpacing = 0.sp,
            ),
        bodyBold14 =
            TextStyle(
                fontFamily = AppleSanDolGothicBold,
                fontSize = 14.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.sp,
            ),
        bodyBold13 =
            TextStyle(
                fontFamily = AppleSanDolGothicBold,
                fontSize = 13.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.sp,
            ),
        bodyRegular13 =
            TextStyle(
                fontFamily = AppleSanDolGothicRegular,
                fontSize = 13.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.sp,
            ),
        bodyMedium13 =
            TextStyle(
                fontFamily = AppleSanDolGothicMedium,
                fontSize = 13.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.sp,
            ),
        bodyBold12 =
            TextStyle(
                fontFamily = AppleSanDolGothicBold,
                fontSize = 12.sp,
                lineHeight = 14.sp,
                letterSpacing = 0.sp,
            ),
        bodySemiBold12 =
            TextStyle(
                fontFamily = AppleSanDolGothicSemiBold,
                fontSize = 12.sp,
                lineHeight = 14.sp,
                letterSpacing = 0.sp,
            ),
        bodyRegular12 =
            TextStyle(
                fontFamily = AppleSanDolGothicRegular,
                fontSize = 12.sp,
                lineHeight = 14.sp,
                letterSpacing = 0.sp,
            ),
        // Button
        buttonExtraBold18 =
            TextStyle(
                fontFamily = AppleSanDolGothicExtraBold,
                fontSize = 18.sp,
                lineHeight = 21.sp,
                letterSpacing = 0.sp,
            ),
        buttonSemiBold19 =
            TextStyle(
                fontFamily = AppleSanDolGothicSemiBold,
                fontSize = 19.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.19.sp,
            ),
        buttonBold14 =
            TextStyle(
                fontFamily = AppleSanDolGothicBold,
                fontSize = 14.sp,
                lineHeight = 17.sp,
                letterSpacing = 0.sp,
            ),
        buttonBold13 =
            TextStyle(
                fontFamily = AppleSanDolGothicBold,
                fontSize = 13.sp,
                lineHeight = 20.sp,
                letterSpacing = (-0.2).sp,
            ),
        buttonRegular13 =
            TextStyle(
                fontFamily = AppleSanDolGothicRegular,
                fontSize = 13.sp,
                lineHeight = 20.sp,
                letterSpacing = (-0.2).sp,
            ),
        // Caption
        captionExtraBold12 =
            TextStyle(
                fontFamily = AppleSanDolGothicExtraBold,
                fontSize = 12.sp,
                lineHeight = 14.sp,
                letterSpacing = (-1).sp,
            ),
        captionBold12 =
            TextStyle(
                fontFamily = AppleSanDolGothicBold,
                fontSize = 12.sp,
                lineHeight = 14.sp,
                letterSpacing = (-0.3).sp,
            ),
        captionRegular11 =
            TextStyle(
                fontFamily = AppleSanDolGothicRegular,
                fontSize = 11.sp,
                lineHeight = 13.sp,
                letterSpacing = 0.2.sp,
            ),
        captionMedium11 =
            TextStyle(
                fontFamily = AppleSanDolGothicMedium,
                fontSize = 11.sp,
                lineHeight = 17.sp,
                letterSpacing = 0.1.sp,
            ),
        captionSemiBold10 =
            TextStyle(
                fontFamily = AppleSanDolGothicSemiBold,
                fontSize = 10.sp,
                lineHeight = 12.sp,
                letterSpacing = 0.sp,
            ),
        captionBold10 =
            TextStyle(
                fontFamily = AppleSanDolGothicBold,
                fontSize = 10.sp,
                lineHeight = 12.sp,
                letterSpacing = (-0.1).sp,
            ),
        captionRegular10 =
            TextStyle(
                fontFamily = AppleSanDolGothicRegular,
                fontSize = 10.sp,
                lineHeight = 12.sp,
                letterSpacing = 0.sp,
            ),
    )

val LocalYes24TicketTypography = staticCompositionLocalOf {
    defaultYes24TicketTypography
}
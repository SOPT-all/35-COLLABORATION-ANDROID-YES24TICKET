package org.andsopt.android.yes24ticket.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme =
    darkColorScheme(
        primary = Purple80,
        secondary = PurpleGrey80,
        tertiary = Pink80,
    )

private val LightColorScheme =
    lightColorScheme(
        primary = Purple40,
        secondary = PurpleGrey40,
        tertiary = Pink40,
    )

/**
 * Color, Typography 사용법:
 *
 * Typography 사용법 : Yes24TicketTheme.typography.~~
 *
 * Color 사용법 : Yes24TicketTheme.colorScheme.~~
 * ```
 * // 예시 샘플
 * Text(
 *     text = "7조 화이팅 yes24",
 *     style = Yes24TicketTheme.typography.bodyBold14,  // Typography
 *     color = Yes24TicketTheme.colorScheme.gray900     // Color
 * )
 */
@Composable
fun YES24TICKETTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme =
        when {
            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                val context = LocalContext.current
                if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
            }

            darkTheme -> DarkColorScheme
            else -> LightColorScheme
        }

    val yes24TicketColorScheme = yes24TicketColorScheme()
    val yes24TicketTypography = defaultYes24TicketTypography

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = {
            CompositionLocalProvider(
                LocalYes24TicketColorScheme provides yes24TicketColorScheme,
                LocalYes24TicketTypography provides yes24TicketTypography,
            ) {
                content()
            }
        },
    )
}

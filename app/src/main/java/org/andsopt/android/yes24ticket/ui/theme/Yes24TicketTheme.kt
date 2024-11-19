package org.andsopt.android.yes24ticket.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

object Yes24TicketTheme {
    val colorScheme: Yes24TicketColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalYes24TicketColorScheme.current

    val typography: Yes24TicketTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalYes24TicketTypography.current
}
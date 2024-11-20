package org.andsopt.android.yes24ticket.presentation.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.presentation.ui.component.InformationFooterConstants.END_INDEX
import org.andsopt.android.yes24ticket.presentation.ui.component.InformationFooterConstants.START_INDEX
import org.andsopt.android.yes24ticket.ui.theme.YES24TICKETTheme
import org.andsopt.android.yes24ticket.ui.theme.defaultYes24TicketTypography

@Composable
fun InformationFooter(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 19.dp),
    ) {
        FooterCSAndPCButton()

        DividerBetweenText(
            startText = R.string.information_footer_privacy_policy,
            endText = R.string.information_footer_terms,
            contentPadding = PaddingValues(8.dp),
            textColor = Color.Black,
            textStyle = defaultYes24TicketTypography.bodyRegular12,
        )

        FooterCompanyInformation()

        Spacer(Modifier.height(2.dp))

        DividerBetweenText(
            startText = R.string.information_footer_business,
            endText = R.string.information_footer_report,
        )

        Spacer(Modifier.height(2.dp))

        DividerBetweenText(
            startText = R.string.information_footer_email,
            endText = R.string.information_footer_service_provider,
        )

        Spacer(Modifier.height(2.dp))

        Text(
            text = stringResource(R.string.information_footer_copyright),
            style = defaultYes24TicketTypography.captionSemiBold10,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )

        FooterLinkButton()
    }
}

@Composable
fun DividerBetweenText(
    @StringRes startText: Int,
    @StringRes endText: Int,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(6.dp),
    textColor: Color = Color.Gray,
    textStyle: TextStyle = defaultYes24TicketTypography.captionSemiBold10,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier =
            modifier
                .fillMaxWidth(),
    ) {
        Text(
            text = stringResource(startText),
            style = textStyle,
            color = textColor,
            modifier = Modifier.padding(end = contentPadding.calculateEndPadding(LocalLayoutDirection.current)),
        )

        VerticalDivider(
            modifier =
                Modifier
                    .height(9.dp),
            thickness = 1.dp,
            color = Color.Red,
        )

        Text(
            text = stringResource(endText),
            style = textStyle,
            color = textColor,
            modifier = Modifier.padding(start = contentPadding.calculateStartPadding(LocalLayoutDirection.current)),
        )
    }
}

@Composable
fun FooterCSAndPCButton(
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier =
            modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
    ) {
        Text(
            text =
                buildAnnotatedString {
                    append(stringResource(R.string.information_footer_cs))
                    addStyle(
                        style =
                            SpanStyle(
                                color = Color.DarkGray,
                                fontFamily = defaultYes24TicketTypography.titleRegular12.fontFamily,
                                fontSize = defaultYes24TicketTypography.titleRegular12.fontSize,
                            ),
                        start = START_INDEX,
                        end = END_INDEX,
                    )
                },
            style = defaultYes24TicketTypography.titleBold12,
            color = Color.Gray,
            modifier = Modifier.padding(end = 7.dp),
        )

        VerticalDivider(
            modifier =
                Modifier
                    .height(9.dp),
            thickness = 1.dp,
            color = Color.Red,
        )

        Text(
            text = stringResource(R.string.information_footer_pc),
            style = defaultYes24TicketTypography.titleBold12,
            color = Color.Gray,
            modifier = Modifier.padding(start = 7.dp),
        )
    }
}

@Composable
private fun FooterCompanyInformation(
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier =
            modifier
                .fillMaxWidth()
                .padding(top = 6.dp),
    ) {
        Text(
            text = stringResource(R.string.information_footer_representative),
            style = defaultYes24TicketTypography.captionSemiBold10,
            color = Color.Gray,
        )

        Text(
            text = stringResource(R.string.information_footer_address),
            style = defaultYes24TicketTypography.captionSemiBold10,
            color = Color.Gray,
            modifier = Modifier.padding(start = 9.dp),
        )
    }
}

@Composable
private fun FooterLinkButton(
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier =
            modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
    ) {
        Text(
            text = stringResource(R.string.information_footer_global),
            style = defaultYes24TicketTypography.captionExtraBold12,
            color = Color.DarkGray,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
        )

        Spacer(Modifier.width(8.dp))

        Text(
            text = stringResource(R.string.information_footer_yes24),
            style = defaultYes24TicketTypography.captionExtraBold12,
            color = Color.DarkGray,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
        )
    }
}

object InformationFooterConstants {
    const val START_INDEX = 0
    const val END_INDEX = 4
}

@Preview
@Composable
private fun InformationFooterPreview() {
    YES24TICKETTheme {
        InformationFooter()
    }
}

package org.andsopt.android.yes24ticket.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.andsopt.android.yes24ticket.R
import org.andsopt.android.yes24ticket.ui.theme.YES24TICKETTheme
import org.andsopt.android.yes24ticket.ui.theme.defaultYes24TicketTypography

@Composable
fun InformationFooter(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 19.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)

        ) {
            Text(
                text = stringResource(R.string.information_footer_cs),
                style = defaultYes24TicketTypography.titleBold12,
                color = Color.Gray,
                modifier = Modifier.padding(end = 7.dp)
            )

            HorizontalDivider(
                modifier = Modifier
                    .width(1.dp)
                    .height(9.dp)
                    .background(Color.Red)
            )

            Text(
                text = stringResource(R.string.information_footer_pc),
                style = defaultYes24TicketTypography.titleBold12,
                color = Color.Gray,
                modifier = Modifier.padding(start = 7.dp)
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.information_footer_privacy_policy),
                style = defaultYes24TicketTypography.bodyRegular12,
                color = Color.Gray,
                modifier = Modifier.padding(end = 7.dp)
            )

            HorizontalDivider(
                modifier = Modifier
                    .width(1.dp)
                    .height(9.dp)
                    .background(Color.Red)
            )

            Text(
                text = stringResource(R.string.information_footer_terms),
                style = defaultYes24TicketTypography.bodyRegular12,
                color = Color.Gray,
                modifier = Modifier.padding(start = 7.dp)
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp)
        ) {
            Text(
                text = stringResource(R.string.information_footer_representative),
                style = defaultYes24TicketTypography.captionSemiBold10,
                color = Color.Gray
            )

            Text(
                text = stringResource(R.string.information_footer_address),
                style = defaultYes24TicketTypography.captionSemiBold10,
                color = Color.Gray,
                modifier = Modifier.padding(start = 9.dp)
            )
        }

        Spacer(Modifier.height(2.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.information_footer_business),
                style = defaultYes24TicketTypography.captionSemiBold10,
                color = Color.Gray,
                modifier = Modifier.padding(end = 7.dp)
            )

            HorizontalDivider(
                modifier = Modifier
                    .width(1.dp)
                    .height(9.dp)
                    .background(Color.Red)
            )

            Text(
                text = stringResource(R.string.information_footer_report),
                style = defaultYes24TicketTypography.captionSemiBold10,
                color = Color.Gray,
                modifier = Modifier.padding(start = 7.dp)
            )
        }

        Spacer(Modifier.height(2.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.information_footer_email),
                style = defaultYes24TicketTypography.captionSemiBold10,
                color = Color.Gray,
                modifier = Modifier.padding(end = 7.dp)
            )

            HorizontalDivider(
                modifier = Modifier
                    .width(1.dp)
                    .height(9.dp)
                    .background(Color.Red)
            )

            Text(
                text = stringResource(R.string.information_footer_service_provider),
                style = defaultYes24TicketTypography.captionSemiBold10,
                color = Color.Gray,
                modifier = Modifier.padding(start = 7.dp)
            )
        }

        Spacer(Modifier.height(2.dp))

        Text(
            text = stringResource(R.string.information_footer_copyright),
            style = defaultYes24TicketTypography.captionSemiBold10,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        ) {
            Text(
                text = stringResource(R.string.information_footer_global),
                style = defaultYes24TicketTypography.captionExtraBold12,
                color = Color.Gray,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
            )

            Spacer(Modifier.width(8.dp))

            Text(
                text = stringResource(R.string.information_footer_yes24),
                style = defaultYes24TicketTypography.captionExtraBold12,
                color = Color.Gray,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun InformationFooterPreview() {
    YES24TICKETTheme {
        InformationFooter()
    }
}
package com.niyaj.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.niyaj.core.ui.R
import com.niyaj.designsystem.theme.IconSizeExtraLarge
import com.niyaj.designsystem.theme.SpaceMedium
import com.niyaj.designsystem.theme.SpaceSmall

@Composable
fun EmptySearch(
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.empty_search_title),
    text: String = stringResource(id = R.string.empty_search_text),
    icon: ImageVector = Icons.Rounded.Search
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(SpaceMedium)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(SpaceSmall, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Search icon",
            tint = MaterialTheme.colors.primaryVariant,
            modifier = Modifier.size(IconSizeExtraLarge)
        )

        Text(
            text = title,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.primaryVariant,
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = text,
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.primaryVariant,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = SpaceSmall)
        )
    }
}
package com.niyaj.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FilterChip
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.niyaj.designsystem.theme.SpaceSmall
import com.niyaj.model.UserPurpose


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CustomChips(
    label: String,
    selectedPurposes: List<UserPurpose>,
    userPurpose: List<UserPurpose>,
    onChipClick: (UserPurpose) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(SpaceSmall)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.body2,
            fontWeight = FontWeight.SemiBold,
        )

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(SpaceSmall, Alignment.Start),
        ) {
            userPurpose.forEach {
                CustomChip(
                    text = it.name,
                    isSelected = selectedPurposes.contains(it),
                    onChipClick = {
                        onChipClick(it)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomChip(
    modifier: Modifier = Modifier,
    text: String,
    isSelected: Boolean,
    onChipClick: () -> Unit,
    borderStroke: BorderStroke = BorderStroke(
        0.6.dp, MaterialTheme.colors.secondary
    )
) {
    FilterChip(
        modifier = modifier,
        selected = isSelected,
        onClick = onChipClick,
        border = borderStroke,
        colors = ChipDefaults.outlinedFilterChipColors(
            selectedBackgroundColor = MaterialTheme.colors.secondary,
            selectedContentColor = MaterialTheme.colors.onPrimary
        )
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.overline
        )
    }
}
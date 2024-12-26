package com.niyaj.feature.refine

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.niyaj.designsystem.theme.SpaceMedium
import com.niyaj.designsystem.theme.SpaceMediumMax
import com.niyaj.model.userPurposes
import com.niyaj.ui.components.CustomChips
import com.niyaj.ui.components.CustomDropdownMenu
import com.niyaj.ui.components.CustomSlider
import com.niyaj.ui.components.CustomTextStatusField
import com.niyaj.ui.components.StandardScaffoldWithoutDrawer

@Composable
fun RefineScreen(
    onBackClick: () -> Unit,
    viewModel: RefineViewModel = hiltViewModel(),
) {
    val scaffoldState = rememberScaffoldState()

    val userAvailabilities = viewModel.userAvailabilities.collectAsStateWithLifecycle().value
    val selectedUserAvailability =
        viewModel.selectedUserAvailability.collectAsStateWithLifecycle().value

    var expanded by remember { mutableStateOf(false) }

    StandardScaffoldWithoutDrawer(
        scaffoldState = scaffoldState,
        onBackClick = onBackClick,
        title = "Refine",
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(SpaceMediumMax),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(SpaceMedium)
        ) {
            CustomDropdownMenu(
                label = "Select Your Availability",
                textValue = selectedUserAvailability.status,
                expanded = expanded,
                onExpandedChange = {
                    expanded = !expanded
                }
            ) {
                userAvailabilities.forEach {
                    DropdownMenuItem(
                        onClick = {
                            viewModel.onEvent(RefineEvent.OnSelectUseAvailability(it))
                            expanded = false
                        }
                    ) {
                        Text(
                            text = it.status,
                            style = MaterialTheme.typography.body2,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
            }


            CustomTextStatusField(
                label = "Add Your Status",
                value = viewModel.userStatus,
                onValueChange = {
                    viewModel.onEvent(RefineEvent.OnChangeStatus(it))
                }
            )

            CustomSlider(
                label = "Select Hyper Local Distance",
                currentValue = viewModel.hyperDistance,
                onValueChanged = {
                    viewModel.onEvent(RefineEvent.OnChangeHyperDistance(it))
                }
            )

            CustomChips(
                label = "Select Purpose",
                selectedPurposes = viewModel.selectedPurpose.toList(),
                userPurpose = userPurposes,
                onChipClick = {
                    viewModel.onEvent(RefineEvent.OnSelectUserPurpose(it))
                }
            )

            Button(
                onClick = {
                    viewModel.onEvent(RefineEvent.OnClickSave)

                    // TODO: Should be navigate after successfully saving data
                    onBackClick()
                },
                modifier = Modifier
                    .fillMaxWidth(0.5f),
                shape = CircleShape,
                elevation = null
            ) {
                Text(
                    text = "Save & Explore"
                )
            }
        }
    }
}
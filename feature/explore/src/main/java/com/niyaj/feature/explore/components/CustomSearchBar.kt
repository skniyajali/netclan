package com.niyaj.feature.explore.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.niyaj.designsystem.theme.IconSizeLarge
import com.niyaj.designsystem.theme.IconSizeMedium
import com.niyaj.designsystem.theme.IconSizeSmall
import com.niyaj.designsystem.theme.SpaceMedium
import com.niyaj.feature.explore.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomSearchBar(
    modifier: Modifier = Modifier,
    search: String,
    focusRequester: FocusRequester,
    focusManager: FocusManager,
    onValueChange: (String) -> Unit,
    onClickFilter: () -> Unit,
    onClearClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(SpaceMedium),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        BasicTextField(
            modifier = Modifier
                .defaultMinSize(minWidth = TextFieldDefaults.MinWidth)
                .height(IconSizeMedium)
                .clip(CircleShape)
                .focusRequester(focusRequester),
            value = search,
            onValueChange = onValueChange,
            cursorBrush = SolidColor(MaterialTheme.colors.primaryVariant),
            textStyle = TextStyle(color = MaterialTheme.colors.primaryVariant),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    focusManager.clearFocus()
                }
            ),
            decorationBox = { innerTextField ->
                TextFieldDefaults.OutlinedTextFieldDecorationBox(
                    value = search,
                    visualTransformation = VisualTransformation.None,
                    innerTextField = innerTextField,
                    placeholder = {
                        Text(
                            text = "Search",
                            style = MaterialTheme.typography.caption
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Icon",
                            tint = MaterialTheme.colors.primaryVariant,
                            modifier = Modifier.size(IconSizeSmall)
                        )
                    },
                    trailingIcon = {
                        if (search.isNotEmpty()) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Search Icon",
                                tint = MaterialTheme.colors.primaryVariant,
                                modifier = Modifier
                                    .size(IconSizeSmall)
                                    .clickable {
                                        onClearClick()
                                    }
                            )
                        }
                    },
                    singleLine = true,
                    enabled = true,
                    interactionSource = interactionSource,
                    contentPadding = PaddingValues(2.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = MaterialTheme.colors.primaryVariant,
                        cursorColor = MaterialTheme.colors.secondaryVariant,
                    ),
                    border = {
                        TextFieldDefaults.BorderBox(
                            enabled = true,
                            isError = false,
                            interactionSource = interactionSource,
                            colors = TextFieldDefaults.outlinedTextFieldColors(),
                            shape = CircleShape
                        )
                    }
                )
            }
        )

        Icon(
            imageVector = Icons.Default.FilterList,
            contentDescription = stringResource(id = R.string.filter_list),
            modifier = Modifier
                .size(IconSizeLarge)
                .clickable(
                    interactionSource = remember {
                        MutableInteractionSource()
                    },
                    indication = null,
                ) {
                    onClickFilter()
                }
        )
    }
}
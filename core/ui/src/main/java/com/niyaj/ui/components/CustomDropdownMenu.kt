package com.niyaj.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.DropdownMenu
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.window.PopupProperties
import com.niyaj.designsystem.theme.IconSizeExtraLarge
import com.niyaj.designsystem.theme.SpaceSmall

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomDropdownMenu(
    label: String,
    textValue: String,
    expanded: Boolean,
    onExpandedChange: () -> Unit,
    shape: Shape = RoundedCornerShape(SpaceSmall),
    borderColor: Color = MaterialTheme.colors.primaryVariant,
    borderStroke: BorderStroke = BorderStroke(0.8.dp, borderColor),
    dropdownItems: @Composable (ColumnScope) -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }

    var textFieldSize by remember { mutableStateOf(Size.Zero) }

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

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                onExpandedChange()
            },
        ) {
            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IconSizeExtraLarge)
                    .clip(shape)
                    .onGloballyPositioned { coordinates ->
                        //This is used to assign to the DropDown the same width
                        textFieldSize = coordinates.size.toSize()
                    },
                value = textValue,
                onValueChange = {},
                minLines = 1,
                readOnly = true,
                cursorBrush = SolidColor(MaterialTheme.colors.primary),
                decorationBox = { innerTextField ->
                    TextFieldDefaults.OutlinedTextFieldDecorationBox(
                        value = textValue,
                        visualTransformation = VisualTransformation.None,
                        innerTextField = innerTextField,
                        placeholder = {
                            Text(
                                text = "Search",
                                style = MaterialTheme.typography.caption
                            )
                        },
                        singleLine = true,
                        enabled = true,
                        interactionSource = interactionSource,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            textColor = MaterialTheme.colors.primaryVariant,
                            cursorColor = MaterialTheme.colors.primary,
                        ),
                        border = {
                            Box(modifier = Modifier.border(borderStroke, shape))
                        },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(
                                expanded = expanded
                            )
                        },
                    )
                }
            )

            DropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    onExpandedChange()
                },
                properties = PopupProperties(
                    focusable = false,
                    dismissOnBackPress = true,
                    dismissOnClickOutside = true,
                    excludeFromSystemGesture = true,
                    clippingEnabled = true,
                ),
                modifier = Modifier
                    .width(with(LocalDensity.current) { textFieldSize.width.toDp() }),
                content = dropdownItems
            )
        }
    }
}
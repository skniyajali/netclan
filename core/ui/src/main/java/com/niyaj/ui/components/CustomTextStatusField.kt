package com.niyaj.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.niyaj.designsystem.theme.SpaceSmall

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomTextStatusField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    singleLine: Boolean = false,
    minLines: Int = 2,
    maxLength: Int = 250,
    shape: Shape = RoundedCornerShape(SpaceSmall),
    borderColor: Color = MaterialTheme.colors.primaryVariant,
    borderStroke: BorderStroke = BorderStroke(0.8.dp, borderColor),
) {
    val interactionSource = remember { MutableInteractionSource() }


    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(SpaceSmall)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.body2,
            fontWeight = FontWeight.Medium,
        )

        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(
                    minWidth = TextFieldDefaults.MinWidth,
                    minHeight = TextFieldDefaults.MinHeight
                )
                .clip(shape),
            value = value,
            onValueChange = {
                if (value.length != maxLength) {
                    onValueChange(it)
                }
            },
            minLines = minLines,
            cursorBrush = SolidColor(MaterialTheme.colors.primary),
            decorationBox = { innerTextField ->
                TextFieldDefaults.OutlinedTextFieldDecorationBox(
                    value = value,
                    visualTransformation = VisualTransformation.None,
                    innerTextField = innerTextField,
                    placeholder = {
                        Text(
                            text = "Search",
                            style = MaterialTheme.typography.caption
                        )
                    },
                    singleLine = singleLine,
                    enabled = true,
                    interactionSource = interactionSource,
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = MaterialTheme.colors.primaryVariant,
                        cursorColor = MaterialTheme.colors.primary,
                    ),
                    border = {
                        Box(modifier = Modifier.border(borderStroke, shape))
                    }
                )
            }
        )

        Text(
            text = "${value.length}/${maxLength}",
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = SpaceSmall)
        )
    }
}
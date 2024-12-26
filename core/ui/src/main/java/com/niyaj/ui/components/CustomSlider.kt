package com.niyaj.ui.components

import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.niyaj.designsystem.theme.SpaceSmall
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

@Composable
fun CustomSlider(
    label: String,
    currentValue: Float,
    onValueChanged: (Float) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(SpaceSmall)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.body2,
            fontWeight = FontWeight.Medium,
        )

        Spacer(modifier = Modifier.height(30.dp))

        CustomSlider(
            modifier = Modifier
                .fillMaxWidth(),
            currentValue = currentValue,
            onValueChanged = onValueChanged
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "1 Km",
                style = MaterialTheme.typography.caption
            )

            Text(
                text = "100 Km",
                style = MaterialTheme.typography.caption
            )
        }
    }
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CustomSlider(
    modifier: Modifier = Modifier,
    currentValue: Float,
    rangeColor: Color = MaterialTheme.colors.primary,
    backColor: Color = MaterialTheme.colors.secondaryVariant,
    barHeight: Dp = 2.dp,
    circleRadius: Dp = 6.dp,
    cornerRadius: CornerRadius = CornerRadius(32f, 32f),
    tooltipSpacing: Dp = 10.dp,
    tooltipWidth: Dp = 30.dp,
    tooltipHeight: Dp = 25.dp,
    tooltipTriangleSize: Dp = 8.dp,
    onValueChanged: (Float) -> Unit,
) {
    val circleRadiusInPx = with(LocalDensity.current) { circleRadius.toPx() }

    var progress2 by remember { mutableFloatStateOf(currentValue) }

    var width by remember { mutableFloatStateOf(0f) }

    var height by remember { mutableFloatStateOf(0f) }

    var rightCircleDragging by remember { mutableStateOf(false) }

    var rightCircleOffset by remember { mutableStateOf(Offset.Zero) }

    val textMeasurer = rememberTextMeasurer()

    val path = Path()


    Canvas(
        modifier = modifier
            .height(barHeight)
            .pointerInteropFilter(
                onTouchEvent = { motionEvent ->
                    when (motionEvent.action) {
                        MotionEvent.ACTION_DOWN -> {
                            val x = motionEvent.x
                            val y = motionEvent.y

                            val dis2 = sqrt(
                                (x - rightCircleOffset.x).pow(2) + (y - rightCircleOffset.y).pow(2)
                            )

                            if (dis2 < circleRadiusInPx) { // right circle clicked
                                rightCircleDragging = true
                            }
                        }

                        MotionEvent.ACTION_MOVE -> {
                            val x = motionEvent.x

                            if (rightCircleDragging) {
                                progress2 = if (x >= width) 1f else x / width
                                rightCircleOffset = rightCircleOffset.copy(x = width * progress2)
                            }
                        }

                        MotionEvent.ACTION_UP -> {
                            rightCircleDragging = false
                            onValueChanged(progress2)
                        }
                    }
                    true
                }
            )
            .onGloballyPositioned {
                rightCircleOffset = Offset(x = it.size.width * progress2, y = it.size.height / 2f)
            }
    ) {
        width = this.size.width
        height = this.size.height

        drawRoundRect(
            color = backColor,
            cornerRadius = cornerRadius,
            topLeft = Offset(x = 0f, y = 0f),
            size = Size(width = width, height = height)
        )

        drawRoundRect(
            color = rangeColor,
            cornerRadius = cornerRadius,
            topLeft = Offset(x = progress2, y = 0f),
            size = Size(width = width * progress2, height = height)
        )

        //draw right circle
        drawCircle(
            color = rangeColor,
            radius = circleRadius.toPx(),
            center = rightCircleOffset,
        )


        val leftR = rightCircleOffset.x - tooltipWidth.toPx() / 2f
        val topR =
            rightCircleOffset.y - tooltipSpacing.toPx() - circleRadiusInPx - tooltipHeight.toPx()


        //draw right Tooltip
        drawPath(
            path.apply {
                reset()
                addRoundRect(
                    RoundRect(
                        left = leftR,
                        top = topR,
                        right = leftR + tooltipWidth.toPx(),
                        bottom = topR + tooltipHeight.toPx(),
                        cornerRadius = CornerRadius(x = 0f, y = 0f)
                    )
                )
                moveTo(
                    x = rightCircleOffset.x - tooltipTriangleSize.toPx(),
                    y = rightCircleOffset.y - circleRadiusInPx - tooltipSpacing.toPx()
                )
                relativeLineTo(tooltipTriangleSize.toPx(), tooltipTriangleSize.toPx())
                relativeLineTo(tooltipTriangleSize.toPx(), -tooltipTriangleSize.toPx())
                close()
            },
            color = rangeColor
        )

        val textRight = (progress2 * 100).roundToInt().toString()
        val textLayoutResult = textMeasurer.measure(
            text = AnnotatedString(textRight),
            style = TextStyle(color = Color.White)
        )
        val textSize = textLayoutResult.size

        drawText(
            textLayoutResult = textLayoutResult,
            topLeft = Offset(
                x = leftR + tooltipWidth.toPx() / 2 - textSize.width / 2,
                y = topR + tooltipHeight.toPx() / 2 - textSize.height / 2
            ),
        )
    }

}

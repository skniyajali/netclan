package com.niyaj.ui.components

import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics

@Composable
fun CustomScrim(
    modifier: Modifier = Modifier,
    color: Color,
    onDismiss: () -> Unit,
    visible: Boolean
) {
    if (color.isSpecified) {
        val alpha by animateFloatAsState(
            targetValue = if (visible) 0.8f else 0f,
            animationSpec = TweenSpec(), label = ""
        )
        val closeDrawer = "OnDismiss"
        val dismissModifier = if (visible) {
            Modifier
                .pointerInput(onDismiss) {
                    detectTapGestures { onDismiss() }
                }
                .semantics(mergeDescendants = true) {
                    contentDescription = closeDrawer
                    onClick { onDismiss(); true }
                }
        } else {
            Modifier
        }

        Canvas(
            modifier
                .fillMaxSize()
                .then(dismissModifier)
        ) {
            drawRect(color = color, alpha = alpha)
        }
    }
}
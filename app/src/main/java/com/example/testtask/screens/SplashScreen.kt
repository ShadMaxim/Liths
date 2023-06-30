package com.example.testtask.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.testtask.R

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onNavigateToMain: () -> Unit = {},
    durationMillis: Int = 2000,
    startAnimSize: Dp = 0.dp
) {
    Surface {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ) {
            var targetAnimSize by remember { mutableStateOf(startAnimSize) }
            val animSize by animateDpAsState(
                targetValue = targetAnimSize,
                animationSpec = tween(durationMillis),
                finishedListener = {
                    onNavigateToMain.invoke()
                }
            )

            var rotate by remember { mutableStateOf(0f) }
            val rotation by animateFloatAsState(
                targetValue = rotate,
                animationSpec = tween(durationMillis)
            )

            var scale by remember { mutableStateOf(0f) }
            val scaling by animateFloatAsState(
                targetValue = scale
            )
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                modifier = Modifier
                    .size(animSize)
                    .rotate(rotation)
                    .scale(scaling)
            )
            LaunchedEffect(Unit) {
                targetAnimSize = 128.dp
                rotate = 360f
                scale = 3f
            }
        }
    }
}
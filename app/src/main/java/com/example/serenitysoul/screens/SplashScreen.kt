package com.example.serenitysoul.screens

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onNavigateToMain: () -> Unit = {},
    durationMillis: Int = 2000,
    //splashViewModel: SplashViewModel = hiltViewModel()
) {
    Surface {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ) {
            LinearIndicator(
                indicatorProgress = 1f,
                onNavigateToMain = onNavigateToMain,
                durationMillis = durationMillis
            )
        }
    }
}

@Composable
fun LinearIndicator(
    modifier: Modifier = Modifier,
    indicatorProgress: Float,
    durationMillis: Int = 2000,
    onNavigateToMain: () -> Unit = {},
) {
    var progress by remember { mutableStateOf(0f) }
    val progressAnimation by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(
            durationMillis = durationMillis,
            easing = FastOutSlowInEasing
        ),
        finishedListener = {
            onNavigateToMain.invoke()
        }
    )
    LinearProgressIndicator(
        modifier = Modifier
            .height(20.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp)),
        progress = progressAnimation
    )
    LaunchedEffect(indicatorProgress) {
        progress = indicatorProgress
    }
}
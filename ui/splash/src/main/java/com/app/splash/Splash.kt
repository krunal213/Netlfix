package com.app.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieAnimatable
import com.airbnb.lottie.compose.rememberLottieComposition
import com.app.theme.NetflixTheme
import kotlinx.coroutines.delay

@Composable
fun Splash(onNavigate: () -> Unit) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation_splash))
    val lottieAnimatable = rememberLottieAnimatable()
    var isProgressBarVisible by remember { mutableStateOf(false) }
    val currentOnNavigate by rememberUpdatedState(onNavigate)
    LaunchedEffect(Unit) {
        lottieAnimatable.animate(
            composition
        )
        isProgressBarVisible = true
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LottieAnimation(
            composition = composition,
            modifier = Modifier.height(200.dp)
        )
        if (isProgressBarVisible) {
            SplashProgressBar(currentOnNavigate)
        }
    }
}

@Composable
private fun SplashProgressBar(currentOnNavigate: () -> Unit) {
    CircularProgressIndicator(
        modifier = Modifier.requiredSize(48.dp),
        strokeWidth = 5.dp,
    )
    LaunchedEffect(Unit) {
        delay(3000)
        currentOnNavigate()
    }
}

@Preview(showBackground = true)
@Composable
fun SplashProgressBarPreview() {
    NetflixTheme {
        SplashProgressBar {}
    }
}


@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    NetflixTheme {
        Splash {}
    }
}
package com.app.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.app.theme.NetflixTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneNumber(onLoginSuccess: () -> Unit, onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                ),
                title = {
                    Text("Netflix")
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val guideLineFromTop = createGuidelineFromTop(16.dp)
            val guideLineFromLeft = createGuidelineFromAbsoluteLeft(16.dp)
            val guideLineFromRight = createGuidelineFromAbsoluteRight(16.dp)
            val (box, readyToWatchTitle, spacerOne, enterInfoTitle, spacerTwo,
                editTextEmailMobile, spacerThree, buttonContinue, spacerFour,
                textHelp, spacerFive, thisPageTitle) = createRefs()
            Box(
                modifier = Modifier
                    .constrainAs(box) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.fillToConstraints
                        height = Dimension.percent(1.5f)
                    }
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFF441518),
                                Color.Black,
                                Color.Black,
                                Color.Black
                            )
                        )
                    )
            )
            Text(
                text = "Ready to watch?",
                modifier = Modifier
                    .padding(innerPadding)
                    .constrainAs(readyToWatchTitle) {
                        top.linkTo(guideLineFromTop)
                        start.linkTo(guideLineFromLeft)
                    },
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier
                .height(16.dp)
                .constrainAs(spacerOne) {
                    top.linkTo(readyToWatchTitle.bottom)
                    start.linkTo(parent.start)
                })
            Text(
                text = "Enter your information to sign in or get started with a new account",
                fontSize = 20.sp,
                lineHeight = 32.sp,
                modifier = Modifier.constrainAs(enterInfoTitle) {
                    top.linkTo(spacerOne.bottom)
                    start.linkTo(guideLineFromLeft)
                    end.linkTo(guideLineFromRight)
                    width = Dimension.fillToConstraints
                }
            )
            Spacer(modifier = Modifier
                .height(24.dp)
                .constrainAs(spacerTwo) {
                    top.linkTo(enterInfoTitle.bottom)
                    start.linkTo(guideLineFromLeft)
                })
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(editTextEmailMobile) {
                        top.linkTo(spacerTwo.bottom)
                        start.linkTo(guideLineFromLeft)
                        end.linkTo(guideLineFromRight)
                        width = Dimension.fillToConstraints
                    },
                label = { Text(text = "Email or mobile number") },
                value = "",
                onValueChange = {},
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.White,
                    focusedLabelColor = Color.White,
                    cursorColor = Color.White
                )
            )
            Spacer(modifier = Modifier
                .height(12.dp)
                .constrainAs(spacerThree) {
                    top.linkTo(editTextEmailMobile.bottom)
                    start.linkTo(guideLineFromLeft)
                })
            Button(
                onClick = onLoginSuccess,
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(buttonContinue) {
                        top.linkTo(spacerThree.bottom)
                        start.linkTo(guideLineFromLeft)
                        end.linkTo(guideLineFromRight)
                        width = Dimension.fillToConstraints
                    }
            ) {
                Text(text = "Continue", fontSize = 20.sp, modifier = Modifier.padding(all = 8.dp))
            }
            Spacer(modifier = Modifier
                .height(40.dp)
                .constrainAs(spacerFour) {
                    top.linkTo(buttonContinue.bottom)
                    start.linkTo(parent.start)
                })
            Text(
                text = "Get Help",
                fontSize = 24.sp,
                modifier = Modifier.constrainAs(textHelp) {
                    top.linkTo(spacerFour.bottom)
                    start.linkTo(guideLineFromLeft)
                })
            Spacer(modifier = Modifier
                .height(40.dp)
                .constrainAs(spacerFive) {
                    top.linkTo(textHelp.bottom)
                    start.linkTo(parent.start)
                })
            Text(
                text = "This page is protected by Google reCAPTCHA to ensure you're not a bot.",
                lineHeight = 24.sp,
                modifier = Modifier.constrainAs(thisPageTitle) {
                    top.linkTo(spacerFive.bottom)
                    start.linkTo(guideLineFromLeft)
                    end.linkTo(guideLineFromRight)
                    width = Dimension.fillToConstraints
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhoneNumberPreview() {
    NetflixTheme {
        PhoneNumber({}, {})
    }
}

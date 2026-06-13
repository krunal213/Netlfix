package com.app.signin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignIn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 40.dp)
    ) {
        Text(text = "Ready to watch?", fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Enter your information to sign in or get started with a new account",
            fontSize = 20.sp,
            lineHeight = 32.sp
        )
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Email or mobile number") },
            value = "",
            onValueChange = {}
        )
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {}, shape = RoundedCornerShape(4.dp), modifier = Modifier.fillMaxWidth()) {
            Text(text = "Continue", fontSize = 20.sp, modifier = Modifier.padding(all = 8.dp))
        }
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Get Help", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "This page is protected by Google reCAPTCHA to ensure you're not a bot.",
            lineHeight = 24.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    SignIn()
}
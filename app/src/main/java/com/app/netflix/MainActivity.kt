package com.app.netflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.getstarted.GetStarted
import com.app.signin.Password
import com.app.theme.NetflixTheme
import com.app.signin.PhoneNumber

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(android.graphics.Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.dark(android.graphics.Color.TRANSPARENT)
        )
        setContent {
            val navController = rememberNavController()
            NetflixTheme {
                NavHost(navController = navController, startDestination = "getStarted") {
                    composable("getStarted") {
                        GetStarted {
                            navController.navigate("phoneNumber")
                        }
                    }
                    composable("phoneNumber") {
                        PhoneNumber(onLoginSuccess = {
                            navController.navigate("password")
                        }, onBackClick = {
                            navController.navigateUp()
                        })
                    }
                    composable("password") {
                        Password()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NetflixTheme {
        PhoneNumber({}, {})
    }
}
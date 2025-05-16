package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {

    var result by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }

    when (result) {
        1 -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {

                Image(
                    painter = painterResource(R.drawable.lemon_tree),
                    contentDescription = "1",
                    modifier = Modifier
                        .wrapContentSize()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF91EBC7))
                        .clickable {
                            result = 2
                            squeezeCount = (1..4).random()
                        }
                )
                Spacer(modifier = Modifier.height(32.dp))

                Text(text = "Tap the lemon tree to select a lemon",
                    fontWeight = FontWeight.Bold)
            }
        }

        2 -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {

                Image(
                    painter = painterResource(R.drawable.lemon_squeeze),
                    contentDescription = "2",
                    modifier = Modifier.wrapContentSize()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF91EBC7))
                        .clickable{
                            squeezeCount--
                            if (squeezeCount == 0) {
                                result = 3
                            }
                        }
                )
                Spacer(
                    modifier = Modifier.height(32.dp))
                Text(text = "Keep tapping the lemon to squeeze it",
                    fontWeight = FontWeight.Bold)
            }
        }

        3 -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(R.drawable.lemon_drink),
                    contentDescription = "3",
                    modifier = Modifier.wrapContentSize()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF91EBC7))
                        .clickable{
                            result = 4
                        }
                )
                Spacer(modifier = Modifier.height(32.dp))
                Text(text = "Tap the lemonade to drink it",
                    fontWeight = FontWeight.Bold)
            }
        }

        4 -> {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ){
                Image(
                    painter = painterResource(R.drawable.lemon_restart),
                    contentDescription = "4",
                    modifier = Modifier.wrapContentSize()
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF91EBC7))
                        .clickable{
                            result = 1
                        }
                )

                Spacer(modifier = Modifier.height(32.dp))
                Text(text = "Tap the empty glass to start again",
                    fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeAppPreview() {
    LemonadeAppTheme {
        LemonadeApp()
    }
}
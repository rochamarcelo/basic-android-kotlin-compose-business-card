package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TopSection(modifier: Modifier = Modifier) {
    val color = colorResource(R.color.primary);
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            contentDescription = "Android logo",
            painter = painterResource(R.drawable.android_logo),
            modifier = Modifier.alpha(.8F).width(50.dp)
        )
        Text(
            text = "Marcelo",
            fontSize = 40.sp,
            color = color,
            fontFamily = FontFamily.Cursive
        )
        Text(
            text = "Software Developer",
            fontWeight = FontWeight.Bold,
            color = color,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier.padding(10.dp).alpha(.8F)
        )
    }
}
@Composable
fun TextIcon(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    iconDescription: String,
    text: String
) {
    val color = colorResource(R.color.secondary);

    Row (
        modifier = modifier.padding(start = 100.dp, bottom = 5.dp),
        horizontalArrangement = Arrangement.Start,
    ){
        Icon(
            imageVector = icon,
            contentDescription = iconDescription,
            tint = color,
        )
        Text(
            text = text,
            color = color,
            modifier = Modifier.padding(start = 5.dp)
        )
    }
}
@Composable
fun BottomSection(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End,
    ) {
        Column (
            modifier = Modifier
                .background(colorResource(R.color.primary))
                .padding(bottom = 30.dp, top = 30.dp),
        ){
            TextIcon (
                modifier = Modifier.fillMaxWidth(),
                icon = Icons.Default.Phone,
                iconDescription = "Phone icon",
                text = "+55 11 99999-9999"
            )
            TextIcon (
                modifier = Modifier.fillMaxWidth(),
                icon = Icons.Default.Share,
                iconDescription = "Share icon",
                text = "@softwareDeveloper"
            )
            TextIcon (
                modifier = Modifier.fillMaxWidth(),
                icon = Icons.Default.Email,
                iconDescription = "Email icon",
                text = "software@developer.com"
            )
        }
    }
}
@Composable
fun BusinessCard(name: String, modifier: Modifier = Modifier) {
    Column (modifier = modifier.fillMaxSize()) {
        TopSection(modifier = Modifier.weight(1f))
        BottomSection(modifier = Modifier.weight(1f))

    }

}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard("Android")
    }
}
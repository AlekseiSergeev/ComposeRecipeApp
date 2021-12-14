package com.example.composerecipeapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composerecipeapp.R


@Preview
@Composable
fun MainContent() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .background(Color(0xFFF2F2F2))
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Image(
            painterResource(id = R.drawable.happy_meal_small),
            contentDescription = "happy mill",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(250.dp)
        )
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Happy Meal",
                    fontSize = 30.sp
                )
                Text(
                    text = "$5.99",
                    fontSize = 20.sp,
                    color = Color.Green,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "800 Calories",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "ORDER NOW")
            }
        }
    }
}

package com.composable.myapplication.ui.theme.boxs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp

@Composable
fun boxces(modifier: Modifier) {
    Column(modifier) {
        Box(
            modifier = modifier
                .weight(1f)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) { Text("benjamine") }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Row(
                modifier = Modifier.fillMaxHeight()
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.Red),
                    contentAlignment = Alignment.Center
                ) {
                    Text("benjamine")
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.Yellow),
                    contentAlignment = Alignment.Center
                ) {
                    Text("benjamine")
                }
            }
        }


        Box(
            modifier = modifier
                .weight(1f)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Cyan), contentAlignment = Alignment.BottomCenter
        ) {
            Text("benjamine")
        }


    }
}
package com.composable.myapplication.ui.theme.constrain_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun tarea(modifier: Modifier) {
    ConstraintLayout(modifier.fillMaxSize()) {
        val (box1, box2, box3, box4, box5, box6, box7, box8, box9) = createRefs()

        Box(
            modifier
                .size(160.dp)
                .background(Color.Red)
                .constrainAs(box1) {

                }
        )
        Box(
            modifier
                .size(90.dp)
                .background(Color.Black)
                .constrainAs(box2) {
                    start.linkTo(box1.start)
                    end.linkTo(box3.end)
                    top.linkTo(box1.top)
                    bottom.linkTo(box3.bottom)

                }
        )
        Box(
            modifier
                .size(160.dp)
                .background(Color.White)
                .constrainAs(box3) {
                    end.linkTo(parent.end)

                }
        )

        Box(
            modifier
                .size(90.dp)
                .background(color = Color.Gray)
                .constrainAs(box4) {
                    top.linkTo(box1.bottom)
                    end.linkTo(box1.end)
                })
        Box(
            modifier
                .size(90.dp)
                .background(color = Color.Green)
                .constrainAs(box5) {
                    top.linkTo(box3.bottom)
                    start.linkTo(box3.start)
                }
        )

        Box(
            modifier
                .size(90.dp)
                .background(color = Color.Yellow)
                .constrainAs(box6) {
                    top.linkTo(box5.bottom)
                    start.linkTo(box4.end)
                }
        )

        Box(
            modifier
                .size(90.dp)
                .background(color = Color.Cyan)
                .zIndex(1f)
                .constrainAs(box7) {

                    top.linkTo(box6.bottom)
                    start.linkTo(box3.start)
                }
        )
        Box(
            modifier
                .size(90.dp)
                .background(color = Color.Blue)
                .zIndex(1f)
                .constrainAs(box8) {
                    top.linkTo(box6.bottom)
                    end.linkTo(box1.end)
                }
        )


        Box(
            modifier
                .size(160.dp)
                .background(Color.LightGray)
                .constrainAs(box9) {
                    top.linkTo(box8.top)
                    end.linkTo(box6.end)
                    start.linkTo(box6.start)
                }
        )

    }


}
package com.composable.myapplication.ui.theme.constrain_layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun constraint(modifier: Modifier) {
    ConstraintLayout(modifier.fillMaxSize()) {
        val (box1, box2, box3, box4,box5) = createRefs()
        Box(
            modifier
                .size(150.dp)
                .background(Color.Red).constrainAs(box1){
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
        )
        Box(
            modifier
                .size(150.dp)
                .background(Color.Black).constrainAs(box2){
                    bottom.linkTo(box1.top)
                }
        )
        Box(
            modifier
                .size(150.dp)
                .background(Color.Blue).constrainAs(box3){
                    bottom.linkTo(box1.top)
                    end.linkTo(parent.end)
                }
        )
        Box(
            modifier
                .size(150.dp)
                .background(Color.Magenta).constrainAs(box4){
                    top.linkTo(box1.bottom)
                    end.linkTo(parent.end)
                }
        )
        Box(
            modifier
                .size(150.dp)
                .background(Color.White).constrainAs(box5){
                    top.linkTo(box1.bottom)

                }
        )


    }
}
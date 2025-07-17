package com.compous.compouse.componentes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun mi_estado(modifier: Modifier) {
    var numero by rememberSaveable { mutableIntStateOf(0) }
//    Column { Text("pulsame:${numero}", modifier.clickable { numero += 1 }) }
    Column(modifier = modifier) {
        myestado(numero) { numero += 1 }
        myestado_2(numero) { numero += 2 }
    }
}

@Composable
fun myestado(numero: Int, listener: () -> Unit) {
    Text("pulsame:$numero", modifier = Modifier.clickable { listener() })
}

@Composable
fun myestado_2(numero: Int, listener: () -> Unit) {
    Text("pulsamos2: $numero", modifier = Modifier.clickable { listener() })
}
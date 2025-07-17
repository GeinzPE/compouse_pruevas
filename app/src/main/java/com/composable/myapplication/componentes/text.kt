package com.compous.compouse.componentes

import android.R
import android.R.attr.text
import android.widget.TextView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintLayoutScope


//@Composable
////fun texto_preview(modifier: Modifier) {
////    Column(modifier = modifier) {
////        Text("hola como estas", fontStyle = FontStyle.Italic, fontSize = 10.sp)
////    }
////
////}

fun ConstraintLayout(
    modifier: Modifier,
    content: (ConstraintLayoutScope) -> Unit
) {
}

@Composable
fun formulario_completo_con_constrain(modifier: Modifier) {
    com.compous.compouse.componentes.ConstraintLayout(modifier.fillMaxSize()) {
        var (com1, com2) = createRefs()
        Box(
            modifier = modifier
                .size(150.dp)
                .background(Color.Red)
                .constrainAs(com1) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
        ) {
        }

        texview_ejemplos(modifier = modifier.constrainAs(com2) {
            top.linkTo(com1.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
    }

}


@Composable
fun texview_ejemplos(modifier: Modifier) {
    var user by rememberSaveable { mutableStateOf("") }
    Column(modifier) {
        MiTextView(modifier,user) { user = it }
        tex_field_paswpr(user) {
            user = it
        }
        if (verificarError(user)) {
            Text(text = " no puede puede tener letras como la a ", color = Color.Red)
            Text(
                text = "deve eliminar la cantidad de ${contarLetrasA(user)} de su texto",
                color = Color.Gray
            )
        }
    }
}

@Composable

fun MiTextView(modifier: Modifier, user: String, listener: (String) -> Unit) {
    OutlinedTextField(
        value = user,
        onValueChange = { listener(it) },
        modifier = modifier.padding(bottom = 40.dp),
        placeholder = { placeholder() },
        isError = verificarError(user),
        label = { placeholder() }
    )
}


fun verificarError(texto: String): Boolean {
    return texto.contains("a", ignoreCase = true)
}

fun contarLetrasA(texto: String): Int {
    return texto.count { it.equals('a', ignoreCase = true) }
}


@Composable
fun placeholder() {
    Text("hola como ests desde otra fu ")
}

@Composable
fun tex_field_paswpr(value: String, onvalue: (String) -> Unit) {
    var contra_oculta by rememberSaveable { mutableStateOf(true) }
    TextField(
        value = value,
        onValueChange = { onvalue(it) },
        singleLine = true,
        label = { placeholder() },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (contra_oculta) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            Text(
                text = if (contra_oculta) "Mostrar" else "ocultar",
                Modifier.clickable { contra_oculta = !contra_oculta })
        }
    )
}

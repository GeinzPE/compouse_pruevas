package com.composable.myapplication.ui.theme

import android.R
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Label
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil3.compose.AsyncImage
import kotlin.math.log

@Composable
fun completado(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (centrado_cabezeros, centrado_campos, login_completo) = createRefs()
        img_centrado(
            modifier = Modifier.constrainAs(centrado_cabezeros) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        Box(
            modifier = Modifier
                .fillMaxHeight(.5f)
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .background(Color.White)
                .constrainAs(centrado_campos) {
                    bottom.linkTo(parent.bottom)
                }
        )

        login_completo(Modifier.constrainAs(login_completo) {
            bottom.linkTo(centrado_campos.bottom)
            top.linkTo(centrado_campos.top)
            start.linkTo(centrado_campos.start)
            end.linkTo(centrado_campos.end)
        })
    }
}


@Composable
fun login_completo(modifier: Modifier) {
    val context = LocalContext.current
    var texto_user by rememberSaveable { mutableStateOf("") }
    var contra by rememberSaveable { mutableStateOf("") }

    ConstraintLayout(modifier = modifier.padding(40.dp)) {
        val (campos, contra_user, texto, btn, textoFinal) = createRefs()

        // 1. Primer campo: arriba
        campos_user(
            modifier = Modifier.constrainAs(campos) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            user = texto_user
        ) { texto_user = it }

        // 2. Segundo campo: debajo del anterior
        campos_contra(
            modifier = Modifier.constrainAs(contra_user) {
                top.linkTo(campos.bottom, margin = 8.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            user_contra = contra
        ) { contra = it }

        // 3. Texto "¿Olvidaste?": debajo del campo de contraseña
        texto_olvidaste(
            modifier = Modifier.constrainAs(texto) {
                top.linkTo(contra_user.bottom, margin = 8.dp)
                end.linkTo(parent.end)
            }
        ) {  Toast.makeText(context, "Hola desde Compose!", Toast.LENGTH_SHORT).show()}

        // 4. Botón de login
        boton_login(
            modifier = Modifier.constrainAs(btn) {
                top.linkTo(texto.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

        // 5. Texto final debajo del botón
        texto_final(
            modifier = Modifier.constrainAs(textoFinal) {
                top.linkTo(btn.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}


@Composable
fun img_centrado(modifier: Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
//        Image(
//            painter = painterResource(R.drawable.ic_delete),
//            contentDescription = "el icono",
//            modifier = modifier.size(20.dp),
//        )
        AsyncImage(
            model = "https://static.vecteezy.com/system/resources/previews/018/930/698/non_2x/facebook-logo-facebook-icon-transparent-free-png.png",
            contentDescription = "imagen de inter",
            modifier = modifier
                .fillMaxWidth(1f)
                .size(350.dp),
            onError = {
                Log.i("image", "ocurrio un error al carga la img${it.result.throwable.message}")
            }
        )
        Text(
            modifier = modifier.fillMaxWidth(1f),
            text = "hola como estas",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace,
            fontStyle = FontStyle.Normal
        )
    }

}

@Composable
fun campos_user(modifier: Modifier, user: String, valor_texto: (String) -> Unit) {
    OutlinedTextField(
        value = user,
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White),
        onValueChange = { valor_texto(it) },
        placeholder = { Text(text = "ingrese su usuario", color = Color.Gray) },
        label = { Text(text = "Ingresa tu usuario", color = Color.Black) },
        trailingIcon = {
            Image(
                painter = painterResource(id = R.drawable.star_on),
                contentDescription = ""
            )
        },
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.star_on),
                contentDescription = "Icono"
            )
        },
    )
}


@Composable
fun campos_contra(
    modifier: Modifier,
    user_contra: String,
    valor_contra: (String) -> Unit
) {
    var contra_oculta by rememberSaveable { mutableStateOf(true) }

    OutlinedTextField(
        value = user_contra,
        onValueChange = { valor_contra(it) },
        modifier = modifier.fillMaxWidth(),
        placeholder = { Text(text = "Ingresa tu contraseña") },
        maxLines = 1,
        isError = verificar_error(user_contra),
        label = { Text("Ingresa tu contraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        visualTransformation = if (contra_oculta) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            val icon = if (contra_oculta) R.drawable.star_on else R.drawable.star_off
            Image(
                painter = painterResource(id = icon),
                contentDescription = if (contra_oculta) "Mostrar contraseña" else "Ocultar contraseña",
                modifier = Modifier.clickable { contra_oculta = !contra_oculta }
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedPlaceholderColor = Color.Black,
            unfocusedPlaceholderColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Black,
            errorTextColor = Color.Black,
            errorLabelColor = Color.Red
        )

    )
}

private fun verificar_error(texto: String): Boolean {
    return texto.contains("9", ignoreCase = true)
}

@Composable
fun texto_olvidaste(modifier: Modifier, onclik:  () -> Unit) {
    Text(
        modifier = modifier.clickable { onclik() },
        text = "Forgot Password?",

        color = Color.Blue,
        textDecoration = TextDecoration.Underline, fontSize = 15.sp
    )
}

@Composable
fun boton_login(modifier: Modifier) {
    ExtendedFloatingActionButton(
        modifier = modifier.fillMaxWidth(),
        containerColor = Color.Red,
        onClick = { "pasamos los datos correctos" }) {
        Text(text = "ingresar")
        Image(painter = painterResource(id = R.drawable.star_on), contentDescription = "")
    }
}


@Composable
fun texto_final(modifier: Modifier) {
    Text(modifier = modifier, text = "Dont have an acoount? sing in", color = Color.Black)
}


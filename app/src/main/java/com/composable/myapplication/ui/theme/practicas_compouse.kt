package com.composable.myapplication.ui.theme

import android.R
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material3.Label
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                .fillMaxHeight(0.5f)
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomEnd = 40.dp))
                .background(Color.Blue)
                .constrainAs(centrado_campos) {
                    bottom.linkTo(parent.bottom)
                }
        )

        login_completo(Modifier.constrainAs(login_completo) {
            bottom.linkTo(centrado_campos.bottom)
        })
    }
}



@Composable
fun login_completo(modifier: Modifier) {
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
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )

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
                .size(250.dp),
            onError = {
                Log.i("image", "ocurrio un error al carga la img${it.result.throwable.message}")
            }
        )
        Text(modifier = modifier, text = "hola como estas", textAlign = TextAlign.Center)
    }

}

@Composable
fun campos_user(modifier: Modifier, user: String, valor_texto: (String) -> Unit) {
    Text(text = "Login in to you account")
    TextField(
        modifier = modifier.fillMaxWidth(),
        onValueChange = { valor_texto(it) },
        value = user,
        placeholder = { Text(text = "ingrese su usuario") })
}

@Composable
fun campos_contra(modifier: Modifier, user_contra: String, valor_contra: (String) -> Unit) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        onValueChange = { valor_contra(it) },
        value = user_contra,
        placeholder = { Text(text = "Ingresa tu contraseña") }
    )
}

@Composable
fun texto_olvidaste(modifier: Modifier) {
    Text(modifier = modifier, text = "Forgot Password?", color = Color.Blue)
}

@Composable
fun boton_login(modifier: Modifier) {
    OutlinedButton(
        modifier = modifier.fillMaxWidth(),
        onClick = { "pasamos los datos correctos" }) {
        Text(text = "clikeame")
    }
}

@Composable
fun texto_final(modifier: Modifier) {
    Text(modifier = modifier, text = "Dont have an acoount? sing in")
}


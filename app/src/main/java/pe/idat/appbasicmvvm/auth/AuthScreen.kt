package pe.idat.appbasicmvvm.auth

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun authScreen(authViewModel: AuthViewModel) {
    Scaffold { paddingInit ->
        Box(
            modifier = Modifier
                .padding(paddingInit)
                .fillMaxSize()
        ) {
            header(Modifier.align(Alignment.TopEnd))
            body(modifier = Modifier.align(Alignment.Center), authViewModel)

        }
    }
}

@Composable
fun header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(imageVector = Icons.Default.Close,
        contentDescription = "Cerrar",
        modifier = modifier.clickable { activity.finish() })
}

@Composable
fun body(modifier: Modifier, authViewModel: AuthViewModel) {
    val usuario:String by authViewModel.usuario.observeAsState(initial = "")
    Column(modifier.padding(start = 10.dp, end = 10.dp)) {
        Spacer(Modifier.size(15.dp))
        txtusuario(usuario) { authViewModel.onLoginValueChanged(it) }

    }
}

@Composable
fun txtusuario(usuario: String, onTextChanged: (String) -> Unit) {
    OutlinedTextField(value = usuario,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = "Usuario") },
        maxLines = 1,
        singleLine = true)
}
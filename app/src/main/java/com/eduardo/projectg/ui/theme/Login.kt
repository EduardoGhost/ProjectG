package com.eduardo.projectg.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eduardo.projectg.R
import com.eduardo.projectg.ui.theme.ui.theme.ProjectGTheme

@Composable
fun Login(){
    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment =
        Alignment.Bottom),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
Icon(painter = painterResource(id = R.drawable.login_icon),
    null,
    Modifier.size(80.dp),
    tint = Color.Blue
)
        TextInput()
        TextInput()
        Button(onClick = {}, modifier = Modifier.size(100.dp))
        {
            Text("Entrar", Modifier.padding(vertical = 8.dp))
        }
        Divider(color = Color.Black.copy(alpha = 0.3f),
        thickness = 1.dp,
            modifier = Modifier.padding(top = 18.dp)

            )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Ainda não tem conta?", color = Color.Black)
            TextButton(onClick = { /*TODO*/ }) {
                Text("Escrever-se")
            }

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput(){
    var value by remember { mutableStateOf("") }
    TextField(value = value, onValueChange = {value = it})
}

@Preview(showBackground = true)
@Composable
fun previewLogin() {
    ProjectGTheme {
        Login()
    }
}
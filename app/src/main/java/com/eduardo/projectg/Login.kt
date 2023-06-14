package com.eduardo.projectg

import android.media.AudioFocusRequest
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        TextInput(InputType.Name)
        TextInput(InputType.Password)
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

sealed class InputType(
    val label: String,
    val icon: ImageVector,
    val keyboardOptions: KeyboardOptions,
    val visualTransformation: VisualTransformation
){
    object Name : InputType(
        label = "UserName",
        icon = Icons.Default.Person,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        visualTransformation = VisualTransformation.None
    )
    object Password : InputType(
        label = "Password",
        icon = Icons.Default.Lock,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done, keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation()
    )
    {

    }

}




@Composable
fun TextInput(inputType: InputType,
//focusRequest: FocusRequester? = null,
//        keyboardActions: KeyboardActions
              ){
    var value by remember { mutableStateOf("") }
    val textFieldShape = RoundedCornerShape(8.dp)

    TextField(value = value,
        onValueChange = {value = it},
        modifier = Modifier.fillMaxWidth(),
        leadingIcon = {Icon(imageVector = inputType.icon,null)},
        label = { Text(text = inputType.label)},
        shape = textFieldShape,
        colors = TextFieldDefaults.textFieldColors(
            Color.Black,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
        ,

//        singleLine = true,
//        keyboardActions = inputType.visualTransformation,
        visualTransformation = inputType.visualTransformation,
        keyboardOptions = inputType.keyboardOptions


    )


}

@Preview(showBackground = true)
@Composable
fun previewLogin() {
    ProjectGTheme {
        Login()
    }
}
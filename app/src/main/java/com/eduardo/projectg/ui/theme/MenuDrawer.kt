package com.eduardo.projectg.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.material3.DrawerValue.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eduardo.projectg.ui.theme.Items.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuDrawer(){
    val drawState = rememberDrawerState(initialValue = Closed)
    val scope = rememberCoroutineScope()
    var text by remember {
        mutableStateOf("")
    }
    ModalNavigationDrawer(
        drawerState = drawState,
        drawerContent = {
            Column(Modifier.fillMaxHeight()) {
                Header(modifier = Modifier.padding(16.dp))

                Body(
                    items = Items.values().toList()) {
                    text = it.label
                    scope.launch {
                        drawState.close()
                    }
                }
            }
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(onClick = { scope.launch { drawState.open() } }) {
                    Text(text = "Open Menu")
                }
                Text(text = text)
            }
        }
    )
}

@Composable
fun Header(modifier: Modifier = Modifier,
           ){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
        ) {
            Icon(imageVector = Icons.Default.Person, contentDescription = null)
                Spacer(modifier = Modifier.size(2.dp))
                Text(text = "User")
    }
}

@Composable
fun Body(items: List<Items>, onClickAction: (Items) -> Unit){
    Column(modifier = Modifier.padding(8.dp)) {
        items.forEach{
            Row(modifier = Modifier.clickable {
                onClickAction.invoke(it)
            }) {
                Icon(imageVector = it.icon, contentDescription = null)
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = it.label)
            }
            Spacer(modifier = Modifier.size(8.dp))
        }
    }
}

enum class Items(val label:String, val icon:ImageVector){
    Item1(label = "Item1", Icons.Default.Home),
    Item2(label = "Item2", Icons.Default.Email),
    Item3(label = "Item3", Icons.Default.Favorite),
    Item4(label = "Item4", Icons.Default.QrCode),
}

@Preview
@Composable
fun previewMenu(){
    MenuDrawer()
}
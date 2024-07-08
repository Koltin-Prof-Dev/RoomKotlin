package mx.edu.dsi_code.admintiempo.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import mx.edu.dsi_code.admintiempo.R
import mx.edu.dsi_code.admintiempo.components.CircleButton
import mx.edu.dsi_code.admintiempo.components.MainIconButton
import mx.edu.dsi_code.admintiempo.components.MainTextField
import mx.edu.dsi_code.admintiempo.components.MainTitle
import mx.edu.dsi_code.admintiempo.components.formatTiempo
import mx.edu.dsi_code.admintiempo.model.Cronos
import mx.edu.dsi_code.admintiempo.viewModels.CronometroViewModel
import mx.edu.dsi_code.admintiempo.viewModels.CronosViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddView(navController: NavController, cronometroVM: CronometroViewModel,cronosVM:CronosViewModel){
    Scaffold(topBar = { CenterAlignedTopAppBar(title = { MainTitle(title = "ADD App Crono") },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ), navigationIcon = { MainIconButton(icon = Icons.Default.ArrowBack) {
            navController.popBackStack()
        }}
    ) }){
        ContentAddView(it,navController,cronometroVM,cronosVM)
    }
}

@Composable
fun ContentAddView(
    it: PaddingValues,
    navController: NavController,
    cronometroVM: CronometroViewModel,
    cronosVM: CronosViewModel
){
    /*traemos el valor de la variable state desde el viewModel
    * el viewModel se pasa del componente principal como parametro
    * */
    val state = cronometroVM.state
    LaunchedEffect(state.cronometroActivo){
        cronometroVM.cronos()
    }
    Column(
        modifier = Modifier
            .padding(it)
            .padding(top = 30.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        /*tiempo esta fuera del state*/
       Text(text = formatTiempo(tiempo = cronometroVM.tiempo),
           fontSize = 50.sp,
           fontWeight = FontWeight.Bold)

        /*Button(onClick = { cronometroVM.iniciar() }) {
            Text(text = "Iniciar")
        }*/

        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(vertical=16.dp)) {
             //inicia el proceso
             CircleButton(icon = painterResource(id = R.drawable.play),enabled = !state.cronometroActivo) {
                 cronometroVM.iniciar()
             }
            //pausa el proceso del tiempo
            CircleButton(icon = painterResource(id = R.drawable.pause),enabled = state.cronometroActivo) {
                cronometroVM.pausar()
            }
            //detiene el proceso del tiempo
            CircleButton(icon = painterResource(id = R.drawable.stop),enabled = !state.cronometroActivo) {
                cronometroVM.detener()
            }
            //mostrar guardar tiempo
            CircleButton(icon = painterResource(id = R.drawable.save),enabled = state.showSaveButton) {
                cronometroVM.showTextField()
            }
        }
        if( state.showTextField ){
            MainTextField(value = state.title, onValueChange = {cronometroVM.onValue(it)}, label = "Title")
            /*Se guarda en base de datos a traves de room*/
            Button(onClick = { cronosVM.addCrono(
                Cronos(
                    title = state.title,
                    crono = cronometroVM.tiempo
                )
            )
                /*detenemos el cronometro*/
                cronometroVM.detener()
                /*regresamos al homeView*/
                navController.popBackStack()
            }) {
                Text(text = "Guardar")
            }
            
        }

    }
}
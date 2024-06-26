package mx.edu.dsi_code.admintiempo.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import mx.edu.dsi_code.admintiempo.components.FloatButton
import mx.edu.dsi_code.admintiempo.components.MainTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController){
    Scaffold(topBar = { CenterAlignedTopAppBar(title = { MainTitle(title = "Timer App")},
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
        ) },
        floatingActionButton = { FloatButton {
            navController.navigate("AddView")
        }}
        ) {

        ContentHomeView(it,navController)
    }
}

@Composable
fun ContentHomeView(it: PaddingValues, navController: NavController ){
    Column(
        modifier =Modifier.padding(it)
    ){

    }
}
package mx.edu.dsi_code.admintiempo.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox
import mx.edu.dsi_code.admintiempo.components.CronCard
import mx.edu.dsi_code.admintiempo.components.FloatButton
import mx.edu.dsi_code.admintiempo.components.MainTitle
import mx.edu.dsi_code.admintiempo.components.formatTiempo
import mx.edu.dsi_code.admintiempo.viewModels.CronosViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController,cronosVM:CronosViewModel){
    Scaffold(topBar = { CenterAlignedTopAppBar(title = { MainTitle(title = "Timer App")},
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
        ) },
        floatingActionButton = { FloatButton {
            navController.navigate("AddView")
        }}
        ) {

        ContentHomeView(it,navController,cronosVM)
    }
}

@Composable
fun ContentHomeView(it: PaddingValues, navController: NavController,cronosVM: CronosViewModel ){
    Column(
        modifier =Modifier.padding(it)
    ){
      /*traemos la lista de los elementos guardados en base de datos*/
        val cronosList by cronosVM.cronosList.collectAsState()
        /*creamos nuestra lazycolumn*/
        LazyColumn{
            items(cronosList){item ->
                val delete = SwipeAction(
                    icon = rememberVectorPainter(Icons.Default.Delete),
                    background = Color.Red,
                    /*
                    * Mandamos llamar la accion de borrado del item
                    * */
                    onSwipe = { cronosVM.deleteCrono(item)}
                )
                SwipeableActionsBox(endActions = listOf(delete), swipeThreshold = 270.dp) {
                    CronCard(item.title,formatTiempo(item.crono)) {
                          navController.navigate("EditView/${item.id}")
                    }
                }

                
            }
        }
    }
}


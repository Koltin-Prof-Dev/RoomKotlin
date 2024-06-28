package mx.edu.dsi_code.admintiempo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.edu.dsi_code.admintiempo.view.AddView
import mx.edu.dsi_code.admintiempo.view.EditView
import mx.edu.dsi_code.admintiempo.view.HomeView
import mx.edu.dsi_code.admintiempo.viewModels.CronometroViewModel
import mx.edu.dsi_code.admintiempo.viewModels.CronosViewModel

@Composable
fun NavManager(cronometroVM: CronometroViewModel ,cronosVM: CronosViewModel){
    /*creamos la instancia del contrladr de navegacion*/
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home"){
        composable("Home"){
            HomeView(navController)
        }
        composable("AddView"){
            AddView(navController,cronometroVM,cronosVM)
        }
        composable("EditView"){
            EditView(navController)
        }
    }
}
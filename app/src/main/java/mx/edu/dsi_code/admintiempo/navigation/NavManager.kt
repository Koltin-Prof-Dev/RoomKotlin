package mx.edu.dsi_code.admintiempo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
            HomeView(navController,cronosVM)
        }
        composable("AddView"){
            AddView(navController,cronometroVM,cronosVM)
        }
        composable("EditView/{id}", arguments = listOf(navArgument("id"){type= NavType.LongType})){
            val id= it.arguments?.getLong("id")?:0
            EditView(navController, cronometroVM, cronosVM,id)
        }
    }
}
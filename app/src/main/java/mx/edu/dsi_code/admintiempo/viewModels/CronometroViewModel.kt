package mx.edu.dsi_code.admintiempo.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import mx.edu.dsi_code.admintiempo.state.CronoState
import kotlinx.coroutines.Job
class CronometroViewModel : ViewModel(){
        var state by mutableStateOf(CronoState())
        private set
       /*el job permite iniciar un proceso que se puede encontrar
       * como pausado, iniciado, detenido*/
        var cronoJob by mutableStateOf<Job?>(null)
           private set
       /*
        *
        *  0L representa un numero largo*/
        var tiempo by mutableStateOf(0L)
        private set

        fun onValue(value:String){
            state = state.copy(title = value)
        }

}
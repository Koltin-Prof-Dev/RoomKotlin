package mx.edu.dsi_code.admintiempo.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import mx.edu.dsi_code.admintiempo.state.CronoState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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

    fun iniciar(){
        state = state.copy(
            cronometroActivo = true
        )
    }

    fun pausar()
    {
        state = state.copy(
            cronometroActivo = false,
            showSaveButton = true
        )
    }
    fun detener(){
        cronoJob?.cancel()
        tiempo =0
        state = state.copy(
            cronometroActivo = false,
            showSaveButton = false,
            showTextField = false
        )
    }
    fun showTextField(){
        state = state.copy(
            cronometroActivo = true
        )
    }
    fun cronos(){
        if(state.cronometroActivo){
            cronoJob?.cancel()
            /*lanzamos la corrutina y comprobamos que se este ejecutando*/
           cronoJob = viewModelScope.launch {
               while (true){
                   delay(1000)
                   /*incrementamos en un segundo el cronometro*/
                   tiempo += 1000
               }
           }

        }
        else{
            /*cancelacion de la corrutina*/
            cronoJob?.cancel()
        }
    }



}
package mx.edu.dsi_code.admintiempo.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import mx.edu.dsi_code.admintiempo.model.Cronos
import mx.edu.dsi_code.admintiempo.repository.CronosRepository
import javax.inject.Inject

@HiltViewModel
class CronosViewModel@Inject constructor(private val repository: CronosRepository): ViewModel(){
    private val _cronosList = MutableStateFlow<List<Cronos>>(emptyList())
    val cronosList = _cronosList.asStateFlow()
    init{
       viewModelScope.launch(Dispatchers.IO) {
           repository.getAllCronos().collect{ item ->
               if(item.isNullOrEmpty()){
                   _cronosList.value = emptyList()
               }
               else{
                   _cronosList.value = item
               }
           }
       }
    }
    fun addCrono(crono: Cronos) = viewModelScope.launch {
        repository.addCrono(crono)
    }
    fun updateCrono(crono: Cronos) = viewModelScope.launch {
        repository.updateCrono(crono)
    }
    fun deleteCrono(crono: Cronos) = viewModelScope.launch {
        repository.deleteCrono(crono)
    }
}
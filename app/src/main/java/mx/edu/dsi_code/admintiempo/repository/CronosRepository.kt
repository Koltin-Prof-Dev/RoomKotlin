package mx.edu.dsi_code.admintiempo.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import mx.edu.dsi_code.admintiempo.model.Cronos
import mx.edu.dsi_code.admintiempo.room.CronosDataBaseDao
import javax.inject.Inject

class CronosRepository @Inject constructor(private val cronosDataBaseDao: CronosDataBaseDao){
    /*
    * Este metodo se encarga de realizar la operacion de insercion de la netidad tipo cronos
    * */
    suspend fun  addCrono(crono: Cronos) = cronosDataBaseDao.insert(crono)
    suspend fun updateCrono(crono:Cronos)= cronosDataBaseDao.update(crono)
    suspend fun  deleteCrono(crono: Cronos) = cronosDataBaseDao.delete(crono)
    /*flow es una corrutina que sencarga de consultar los registroos a traves de un hilo diferente*/
    fun getAllCronos() : Flow<List<Cronos>> =cronosDataBaseDao.getCronos().flowOn(Dispatchers.IO).conflate()
    fun getCronoById(id:Long) : Flow<Cronos> = cronosDataBaseDao.getCronosById(id).flowOn(Dispatchers.IO).conflate()
}
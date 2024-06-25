package mx.edu.dsi_code.admintiempo.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import mx.edu.dsi_code.admintiempo.model.Cronos



//Interface -> Repositorio -> ViewModel -> View
@Dao  /*Data Access Observer*/
interface CronosDataBaseDao {

    /*Establecemos las operaciones crud*/
    @Query("SELECT * FROM Cronos")  /*las querys van ligadas aun metodo y regresan un flow*/
    fun getCronos(): Flow<List<Cronos>>

    @Query("SELECT * FROM  Cronos WHERE id =:id")
    fun getCronosById(id: Long): Flow<Cronos>

    /*funcion suspendida para hacer la insercion utilizando la estrategia de
    * insercion remplazando todo
    * */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(crono:Cronos)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(crono:Cronos)
    @Delete
    suspend fun delete(crono:Cronos)

}
package mx.edu.dsi_code.admintiempo.room

import androidx.room.Database
import androidx.room.RoomDatabase
import mx.edu.dsi_code.admintiempo.model.Cronos


@Database(entities = [Cronos::class], version = 1, exportSchema = false
)
abstract class CronosDataBase: RoomDatabase(){
    abstract fun cronosDao(): CronosDataBaseDao  /*se implementa la funcionalidad de la base de datos*/
}

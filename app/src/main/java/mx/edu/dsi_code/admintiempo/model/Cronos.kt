package mx.edu.dsi_code.admintiempo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*Declaracion de una entidad  utilizamos el decorador entity*/
@Entity(tableName="Cronos")
data class Cronos(

    @PrimaryKey(autoGenerate = true)
    val id: Long=0,
    @ColumnInfo(name= "title")
    val title: String,
    @ColumnInfo(name="crono")
    val crono: Long
)

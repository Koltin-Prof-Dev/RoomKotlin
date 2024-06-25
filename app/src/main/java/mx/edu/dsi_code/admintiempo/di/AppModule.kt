package mx.edu.dsi_code.admintiempo.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import mx.edu.dsi_code.admintiempo.room.CronosDataBase
import mx.edu.dsi_code.admintiempo.room.CronosDataBaseDao
import javax.inject.Singleton

//creamos un objeto
@Module
@InstallIn(SingletonComponent:: class)  //para la inyeccion de las dependencias se utiliza el patron singleton
object AppModule {

    //se crea la instancia d euna clase para pasarla como un parametro es decir inyectarla como parametro
    @Singleton
    @Provides
    /*en esta funcion inyectamos la clase cronosDataBase para poder trabajar con el acceso a base de datos*/
    fun providesCronosDao(cronoDataBase:CronosDataBase): CronosDataBaseDao{
        return cronoDataBase.cronosDao()
    }
    @Singleton
    @Provides
    /*inyectamos */
    fun providesCronosDataBase(@ApplicationContext context: Context): CronosDataBase
    {
        /*creamos la base de datos a traves de los parametros siguientes */
        return Room.databaseBuilder(
            context,
            CronosDataBase::class.java,
            "cronos_db"
        ).fallbackToDestructiveMigration().build()  ///terminamos por construir toda la base de datos.
    }
}
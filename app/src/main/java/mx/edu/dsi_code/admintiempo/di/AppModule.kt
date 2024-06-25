package mx.edu.dsi_code.admintiempo.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mx.edu.dsi_code.admintiempo.room.CronosDataBase
import mx.edu.dsi_code.admintiempo.room.CronosDataBaseDao
import javax.inject.Singleton

//creamos un objeto
@Module
@InstallIn(SingletonComponent:: class)
object AppModule {

    @Singleton
    @Provides
    fun providesCronosDao(cronoDataBase:CronosDataBase): CronosDataBaseDao{
        return cronoDataBase.cronosDao()
    }
}
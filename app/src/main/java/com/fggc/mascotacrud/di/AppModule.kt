package com.fggc.mascotacrud.di

import android.content.Context
import androidx.room.Room
import com.fggc.mascotacrud.core.Constants.Companion.MASCOTA_TABLE
import com.fggc.mascotacrud.data.network.MascotaDB
import com.fggc.mascotacrud.data.network.MascotaDao
import com.fggc.mascotacrud.data.repository.MascotaRepositoryImpl
import com.fggc.mascotacrud.domain.repository.MascotaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideMascotaDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(context,
    MascotaDB::class.java,
        MASCOTA_TABLE
        ).build()

    @Provides
    fun provideMascotaDao(
        mascotaDB: MascotaDB
    ) = mascotaDB.mascotaDao()

    @Provides
    fun provideMascotaRepository(
        mascotaDao: MascotaDao
    ): MascotaRepository = MascotaRepositoryImpl(
        mascotaDao = mascotaDao
    )

}


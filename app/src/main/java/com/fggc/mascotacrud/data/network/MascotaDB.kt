package com.fggc.mascotacrud.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fggc.mascotacrud.domain.model.Mascota

@Database(entities = [Mascota::class], version = 1, exportSchema = false)
abstract  class MascotaDB: RoomDatabase() {
    abstract fun mascotaDao(): MascotaDao
}
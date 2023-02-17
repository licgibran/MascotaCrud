package com.fggc.mascotacrud.data.network

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.IGNORE
import com.fggc.mascotacrud.core.Constants.Companion.MASCOTA_TABLE
import com.fggc.mascotacrud.domain.model.Mascota
import com.fggc.mascotacrud.domain.repository.Mascotas
import kotlinx.coroutines.flow.Flow

@Dao
interface MascotaDao {
    @Query("SELECT * FROM $MASCOTA_TABLE ORDER BY id ASC")
    fun getMascotas(): Flow<Mascotas>

    @Insert(onConflict = IGNORE)
    fun addMascota(mascota: Mascota)

    // getMascota
    @Query("SELECT * FROM $MASCOTA_TABLE WHERE id = :id")
    fun getMascota(id: Int): Mascota

    // updateMascota
    @Update
    fun updateMascota(mascota: Mascota)

    // deleteMascota
    @Delete
    fun deleteMascota(mascota: Mascota)

}
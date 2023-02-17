package com.fggc.mascotacrud.domain.repository

import com.fggc.mascotacrud.domain.model.Mascota
import kotlinx.coroutines.flow.Flow

typealias Mascotas = List<Mascota>
interface MascotaRepository {
    fun getMascotasFromRoom() : Flow<Mascotas>
    fun addMascotaToRoom(mascota: Mascota)
    // getMascotaFromRoom
    fun getMascotaFromRoom(id: Int): Mascota
    //updateMascotaInRoom
    fun updateMascotaInRoom(mascota: Mascota)
    //deleteMascotaFromRoom
    fun deleteMascotaFromRoom(mascota: Mascota)


}
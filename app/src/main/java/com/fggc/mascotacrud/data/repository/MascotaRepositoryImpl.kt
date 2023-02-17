package com.fggc.mascotacrud.data.repository

import com.fggc.mascotacrud.data.network.MascotaDao
import com.fggc.mascotacrud.domain.model.Mascota
import com.fggc.mascotacrud.domain.repository.MascotaRepository

class MascotaRepositoryImpl (
    private  val mascotaDao: MascotaDao
        ): MascotaRepository{
        override fun getMascotasFromRoom() = mascotaDao.getMascotas()
        override fun addMascotaToRoom(mascota: Mascota) = mascotaDao.addMascota(mascota)

    // getMascota
    override fun getMascotaFromRoom(id: Int) = mascotaDao.getMascota(id)

    // updateMascotas
    override fun updateMascotaInRoom(mascota: Mascota) =
        mascotaDao.updateMascota(mascota)

    // deleteMascota
    override fun deleteMascotaFromRoom(mascota: Mascota) =
        mascotaDao.deleteMascota(mascota)


        }

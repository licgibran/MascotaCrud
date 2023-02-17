package com.fggc.mascotacrud.presentation.mascotas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fggc.mascotacrud.core.Constants.Companion.NO_VALUE
import com.fggc.mascotacrud.domain.model.Mascota
import com.fggc.mascotacrud.domain.repository.MascotaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MascotasViewModel @Inject constructor(
    private val repo: MascotaRepository
): ViewModel() {

    var mascota by mutableStateOf(Mascota(0, NO_VALUE, NO_VALUE))
    var openDialog by mutableStateOf(false)
    val mascotas = repo.getMascotasFromRoom()
    fun addMascota(mascota: Mascota)= viewModelScope.launch(Dispatchers.IO)
    {
        repo.addMascotaToRoom(mascota)
    }
    fun closeDialog(){
        openDialog = false
    }
    fun openDialog(){
        openDialog = true
    }
    fun deleteMascota(mascota: Mascota) =
        viewModelScope.launch(Dispatchers.IO){
            repo.deleteMascotaFromRoom(mascota)
        }

    fun updateAnimal(animal: String){
        mascota = mascota.copy(
            animal = animal
        )
    }

    fun updateRaza(raza: String){
        mascota = mascota.copy(
            raza = raza
        )
    }

    fun updateMascota(mascota: Mascota) =
        viewModelScope.launch(Dispatchers.IO){
            repo.updateMascotaInRoom(mascota)
        }

    fun getMascota(id: Int) = viewModelScope.launch(
        Dispatchers.IO
    ) {
        mascota = repo.getMascotaFromRoom(id)
    }
}
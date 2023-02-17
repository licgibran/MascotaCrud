package com.fggc.mascotacrud.presentation.update_mascotas

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.fggc.mascotacrud.presentation.mascotas.MascotasViewModel
import com.fggc.mascotacrud.presentation.update_mascotas.components.UpdateMascotaContent
import com.fggc.mascotacrud.presentation.update_mascotas.components.UpdateMascotaTopBar

@Composable
fun UpdateMascotaScreen(
    viewModel: MascotasViewModel = hiltViewModel(),
    mascotaId: Int,
    navigateBack: () -> Unit
){
    LaunchedEffect(Unit){
        viewModel.getMascota(mascotaId)
    }
    Scaffold(
        topBar = {
            UpdateMascotaTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateMascotaContent(
                padding = padding,
                mascota = viewModel.mascota,
                updateAnimal = { animal->
                    viewModel.updateAnimal(animal)
                },
                updateRaza = {raza->
                    viewModel.updateRaza(raza)
                },
                updateMascota = {mascota ->
                    viewModel.updateMascota(mascota)
                },
                navigateBack = navigateBack
            )
        }
    )
}
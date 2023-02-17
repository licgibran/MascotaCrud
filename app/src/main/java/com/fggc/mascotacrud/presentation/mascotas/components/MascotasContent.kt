package com.fggc.mascotacrud.presentation.mascotas.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fggc.mascotacrud.domain.model.Mascota
import com.fggc.mascotacrud.domain.repository.Mascotas


@Composable
fun MascotasContent(
    padding: PaddingValues,
    mascotas: Mascotas,
    deleteMascota: (mascota:Mascota) -> Unit,
    navigateToUpdateMascotaScreen: (mascotaId: Int) -> Unit
){
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ){
        items(mascotas){
            mascota->
            MascotaCard(
                mascota = mascota,
                deleteMascota = {
                    deleteMascota(mascota)
                },
                navigateToUpdateMascotaScreen =
                    navigateToUpdateMascotaScreen
            )
        }
    }
}
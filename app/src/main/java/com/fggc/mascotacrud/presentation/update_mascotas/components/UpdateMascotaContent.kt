package com.fggc.mascotacrud.presentation.update_mascotas.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fggc.mascotacrud.core.Constants.Companion.ANIMAL
import com.fggc.mascotacrud.core.Constants.Companion.RAZA
import com.fggc.mascotacrud.core.Constants.Companion.UPDATE
import com.fggc.mascotacrud.domain.model.Mascota

@Composable
fun UpdateMascotaContent(
    padding: PaddingValues,
    mascota: Mascota,
    updateAnimal: (animal: String) -> Unit,
    updateRaza: (raza: String) -> Unit,
    updateMascota: (mascota:Mascota) -> Unit,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        TextField(
            value = mascota.animal,
            onValueChange = {animal->
                updateAnimal(animal)
            },
            placeholder = {
                Text(ANIMAL)
            }
        )
        Spacer(modifier = Modifier
            .height(8.dp))
        TextField(
            value = mascota.raza,
            onValueChange = {raza->
                updateRaza(raza)
            },
            placeholder = {
                Text(RAZA)
            }
        )
        Button(
            onClick = {
                updateMascota(mascota)
                navigateBack()
            }
        ){
            Text(UPDATE)
        }
    }
}







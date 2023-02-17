package com.fggc.mascotacrud.presentation.mascotas

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.fggc.mascotacrud.core.Constants.Companion.MASCOTAS_SCREEN
import com.fggc.mascotacrud.presentation.mascotas.components.AddMascotaAlertDialog
import com.fggc.mascotacrud.presentation.mascotas.components.AddMascotaFloatingActionButton
import com.fggc.mascotacrud.presentation.mascotas.components.MascotasContent

@Composable
fun MascotasScreen(
    viewModel: MascotasViewModel = hiltViewModel(),
    navigateToUpdateMascotaScreen: (mascotaId: Int) -> Unit
){
    val mascotas by viewModel.mascotas.collectAsState(
        initial = emptyList() )
    Scaffold(
        topBar ={
            TopAppBar(title = {
                Text(MASCOTAS_SCREEN)
            })
        },
        content = {
            padding->
            MascotasContent(
                padding = padding,
                mascotas = mascotas,
                deleteMascota = {
                    mascota ->
                    viewModel.deleteMascota(mascota)
                },
                navigateToUpdateMascotaScreen =
                    navigateToUpdateMascotaScreen
            )
            AddMascotaAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addMascota = {mascota->
                    viewModel.addMascota(mascota)
                }
            )
        },
        floatingActionButton = {
            AddMascotaFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}
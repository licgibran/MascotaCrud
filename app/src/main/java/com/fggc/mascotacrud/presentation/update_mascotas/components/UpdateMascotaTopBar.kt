package com.fggc.mascotacrud.presentation.update_mascotas.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import com.fggc.mascotacrud.core.Constants.Companion.UPDATE_MASCOTAS_SCREEN

@Composable
fun UpdateMascotaTopBar (
    navigateBack: () -> Unit
){
    TopAppBar(
        title = {
            Text(UPDATE_MASCOTAS_SCREEN)
        },
        navigationIcon = {
            IconButton(onClick = { navigateBack() }) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = null)
            }
        }
    )
}
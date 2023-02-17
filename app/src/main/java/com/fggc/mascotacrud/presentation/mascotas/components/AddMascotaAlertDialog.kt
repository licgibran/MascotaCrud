package com.fggc.mascotacrud.presentation.mascotas.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import com.fggc.mascotacrud.core.Constants.Companion.ADD
import com.fggc.mascotacrud.core.Constants.Companion.ADD_MASCOTA
import com.fggc.mascotacrud.core.Constants.Companion.ANIMAL
import com.fggc.mascotacrud.core.Constants.Companion.DISMISS
import com.fggc.mascotacrud.core.Constants.Companion.NO_VALUE
import com.fggc.mascotacrud.core.Constants.Companion.RAZA
import com.fggc.mascotacrud.domain.model.Mascota
import kotlinx.coroutines.job

@Composable
fun AddMascotaAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addMascota: (mascota: Mascota) -> Unit
){
    if (openDialog){
        var animal by remember { mutableStateOf(NO_VALUE)}
        var raza by remember { mutableStateOf(NO_VALUE)}
        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = { closeDialog },
            title = {
                Text(ADD_MASCOTA)
            },
            text = {
                Column() {
                    TextField(
                        value = animal,
                        onValueChange = {animal = it},
                        placeholder = {
                            Text(ANIMAL)
                        },
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    LaunchedEffect(Unit){
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = raza,
                        onValueChange = {raza = it},
                        placeholder = {
                            Text(RAZA)
                        }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val mascota = Mascota(0,animal,raza)
                        addMascota(mascota)
                    }) {
                    Text(ADD)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog) {
                    Text(DISMISS)
                }
            }

        )
    }
}
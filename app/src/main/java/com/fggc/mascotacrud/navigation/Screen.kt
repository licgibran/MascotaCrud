package com.fggc.mascotacrud.navigation

import com.fggc.mascotacrud.core.Constants.Companion.MASCOTAS_SCREEN
import com.fggc.mascotacrud.core.Constants.Companion.UPDATE_MASCOTAS_SCREEN

sealed class Screen(val route: String){
    object MascotasScreen: Screen(MASCOTAS_SCREEN)
    object UpdateMascotaScreen: Screen(UPDATE_MASCOTAS_SCREEN)
}

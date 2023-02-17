package com.fggc.mascotacrud.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.fggc.mascotacrud.core.Constants.Companion.MASCOTA_ID
import com.fggc.mascotacrud.navigation.Screen.*
import com.fggc.mascotacrud.presentation.mascotas.MascotasScreen
import com.fggc.mascotacrud.presentation.update_mascotas.UpdateMascotaScreen

@Composable
fun NavGraph(
    navController: NavHostController
){
    NavHost(navController = navController,
        startDestination =  MascotasScreen.route ){
        composable(
            route = MascotasScreen.route
        ){
            MascotasScreen(
                navigateToUpdateMascotaScreen = {
                    mascotaId ->
                    navController.navigate(
                        "${UpdateMascotaScreen.route}/${mascotaId}")
                }
            )
        }
        composable(
            route = "${UpdateMascotaScreen.route}/{$MASCOTA_ID}",
            arguments = listOf(
                navArgument(MASCOTA_ID){
                    type = NavType.IntType
                }
            )
        ){
            backStackEntry ->
            val mascotaId = backStackEntry.arguments?.getInt(MASCOTA_ID) ?:0
            UpdateMascotaScreen(
                mascotaId = mascotaId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
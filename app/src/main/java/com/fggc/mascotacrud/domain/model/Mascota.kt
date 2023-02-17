package com.fggc.mascotacrud.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fggc.mascotacrud.core.Constants.Companion.MASCOTA_TABLE

@Entity (tableName = MASCOTA_TABLE)
data class Mascota(
    @PrimaryKey (autoGenerate = true)
    val id : Int,
    val animal: String,
    val raza: String
)

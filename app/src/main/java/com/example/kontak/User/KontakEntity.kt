package com.example.kontak.User

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabel_kontak")
data class KontakEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var nama: String,
    var nomorhp: String,
    var alamat: String
)
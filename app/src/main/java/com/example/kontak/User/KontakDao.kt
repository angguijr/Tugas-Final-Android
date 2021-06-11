package com.example.kontak.User

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface KontakDao {

    @Query("SELECT * FROM tabel_kontak")
    fun getkontaks(): LiveData<List<KontakEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertKontak(kontakEntity: KontakEntity)

    @Update
    fun updateKontak(kontakEntity: KontakEntity)

    @Delete
    fun deleteKontak(kontakEntity: KontakEntity)

}
package com.example.kontak.User

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class KontakRepository(application: Application) {

    private val kontakDao: KontakDao
    private var kontaks: LiveData<List<KontakEntity>>? = null

    init {
        val db = UserDatabase.getDatabase(application.applicationContext)
        kontakDao = db.kontakDao()
        kontaks = kontakDao.getkontaks()
    }

    fun getKontaks(): LiveData<List<KontakEntity>>? {
        return kontaks
    }

    fun insert(kontakEntity: KontakEntity) = runBlocking {
        this.launch(Dispatchers.IO) {
            kontakDao.insertKontak(kontakEntity)
        }
    }

    fun delete(kontakEntity: KontakEntity) {
        runBlocking {
            this.launch(Dispatchers.IO) {
                kontakDao.deleteKontak(kontakEntity)
            }
        }
    }

    fun update(kontakEntity: KontakEntity) = runBlocking {
        this.launch(Dispatchers.IO) {
            kontakDao.updateKontak(kontakEntity)
        }
    }

}
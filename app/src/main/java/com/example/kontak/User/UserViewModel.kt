package com.example.kontak.User

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class UserViewModel(application: Application): AndroidViewModel(application) {

    private var repository = KontakRepository(application)
    private var kontaks: LiveData<List<KontakEntity>>? = repository.getKontaks()

    fun insertKontak(kontakEntity: KontakEntity) {
        repository.insert(kontakEntity)
    }

    fun getKontaks(): LiveData<List<KontakEntity>>? {
        return kontaks
    }

    fun deleteKontak(kontakEntity: KontakEntity) {
        repository.delete(kontakEntity)
    }

    fun updateKontak(kontakEntity: KontakEntity) {
        repository.update(kontakEntity)
    }

}
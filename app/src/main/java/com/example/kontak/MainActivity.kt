package com.example.kontak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kontak.User.KontakEntity
import com.example.kontak.User.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewmodel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewmodel = ViewModelProvider(this).get(UserViewModel::class.java)

        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = LinearLayoutManager(this)

        viewmodel.getKontaks()?.observe(this, Observer {
            recyclerview.adapter = Adapter(it, object: Adapter.Listener {
                override fun onClick(kontakEntity: KontakEntity) {
                    showUpdateDialog(kontakEntity)
                }
            })
        })

        addBtn.setOnClickListener {
            showAddDialog()
        }
    }

    private fun showUpdateDialog(kontakEntity: KontakEntity) {
        //
    }

    private fun showAddDialog() {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog, null)
        val builder = this.let {
            AlertDialog.Builder(it)
                .setView(dialogView)
        }
        val mDialog = builder?.show()
        with(dialogView) {
            hapusBtn.visibility = View.GONE
            savebtn.setOnClickListener {
                val nama = namainput.text.toString()
                val nomor = nomorhpinput.text.toString()
                val alamat = alamatinput.text.toString()
                if( nama != "" &&  nomor != "" &&  alamat != "") {
                    viewmodel.insertKontak(
                        KontakEntity(
                            0, nama, nomor, alamat
                        )
                    )
                    mDialog?.dismiss()
                    Toast.makeText(this@MainActivity, "Kontak Berhasil Ditambahkan", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@MainActivity, "Harap Mengisi Semua Kolom", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
package com.example.kontak

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kontak.User.KontakEntity
import kotlinx.android.synthetic.main.item_kontak.view.*

class Adapter(private val list: List<KontakEntity>, private val listener: Adapter.Listener): RecyclerView.Adapter<Adapter.Holder>() {

    interface Listener {
        fun onClick(kontakEntity: KontakEntity)
    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(kontakEntity: KontakEntity, listener: Listener) {
            with(itemView) {
                nama.text = kontakEntity.nama
                nomorhp.text = kontakEntity.nomorhp
                alamat.text = kontakEntity.alamat
                itemView.setOnClickListener {
                    listener.onClick(kontakEntity)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_kontak, parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Adapter.Holder, position: Int) {
        holder.bind(list[position], listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }


}
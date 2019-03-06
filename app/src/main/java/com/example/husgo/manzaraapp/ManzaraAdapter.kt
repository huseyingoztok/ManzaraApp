package com.example.husgo.manzaraapp

import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import kotlinx.android.synthetic.main.tek_satir_layout.view.*

class ManzaraAdapter(tumManzaralar: ArrayList<Manzara>) : RecyclerView.Adapter<ManzaraAdapter.ManzaraViewHolder>() {
    var manzaralar = tumManzaralar
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManzaraViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var cardView = inflater.inflate(R.layout.tek_satir_layout, parent, false)

        return ManzaraViewHolder(cardView)
    }

    override fun getItemCount(): Int {
        return manzaralar.size
    }

    override fun onBindViewHolder(holder: ManzaraViewHolder, position: Int) {
        var oAnkiManzara = manzaralar[position]
        holder.setData(oAnkiManzara, position)
        /*
        holder.baslik.text=manzaralar.get(position).baslik
        holder.aciklama.text=manzaralar.get(position).aciklama
        holder.resim.setImageResource(manzaralar.get(position).resim)
*/

    }


    inner class ManzaraViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) { //inner sayesinde manzaralar listesine erişebiliyoruz

        var mycardView = itemView as CardView

        var baslik = mycardView.tvBaslik
        var aciklama = mycardView.tvAciklama
        var resim = mycardView.imageViewManzara
        var btnDelete=mycardView.imageViewDelete
        var btnCopy=mycardView.imageViewCopy
        fun setData(oAnkiManzara: Manzara, position: Int) {
            baslik.text=oAnkiManzara.baslik
            aciklama.text=oAnkiManzara.aciklama
            resim.setImageResource(oAnkiManzara.resim)

            btnDelete.setOnClickListener {
                manzaralar.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position,manzaralar.size)
            }

            btnCopy.setOnClickListener {
                manzaralar.add(position,oAnkiManzara)
                notifyItemInserted(position)
                notifyItemRangeChanged(position,manzaralar.size)
            }
        }




    }

}
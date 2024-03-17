package pe.edu.idat.appgrupo03

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.RatingBar
import androidx.recyclerview.widget.RecyclerView

class ResenaAdapter(private val dataSet: List<Resena>) :
    RecyclerView.Adapter<ResenaAdapter.ResenaViewHolder>() {

    class ResenaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombreTextView: TextView = view.findViewById(R.id.textNombre)
        val resenaTextView: TextView = view.findViewById(R.id.textResena)
        val fechaTextView: TextView = view.findViewById(R.id.textFecha)
        val estrellasRatingBar: RatingBar = view.findViewById(R.id.ratingEstrellas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResenaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_resena, parent, false)
        return ResenaViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResenaViewHolder, position: Int) {
        val resena = dataSet[position]
        holder.nombreTextView.text = resena.nombre
        holder.resenaTextView.text = resena.resena
        holder.fechaTextView.text = resena.fecha
        holder.estrellasRatingBar.rating = resena.estrellas.toFloat()
    }

    override fun getItemCount() = dataSet.size
}

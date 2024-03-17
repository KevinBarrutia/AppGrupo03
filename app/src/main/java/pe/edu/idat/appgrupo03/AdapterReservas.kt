package pe.edu.idat.appgrupo03

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.edu.idat.appgrupo03.databinding.ItemReservaBinding

class AdapterReservas (val listaReservas: List<Reserva>) :
    RecyclerView.Adapter<AdapterReservas.ViewHolder>() {
    inner class ViewHolder(val binding: ItemReservaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemReservaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = listaReservas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvNroReseva.text = "${position + 1}"
        holder.binding.tvTipo.text = listaReservas[position].tipo
        holder.binding.tvCantidad.text = listaReservas[position].cantidad
        holder.binding.tvFechaInicio.text = listaReservas[position].fechaInicio
        holder.binding.tvFechaFin.text = listaReservas[position].fechaFin
    }

}
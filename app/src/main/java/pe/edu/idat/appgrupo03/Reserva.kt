package pe.edu.idat.appgrupo03

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Reserva(val tipo: String, val cantidad: String, val fechaInicio: String, val fechaFin: String): Parcelable

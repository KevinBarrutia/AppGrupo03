package pe.edu.idat.appgrupo03

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import pe.edu.idat.appgrupo03.databinding.FragmentFormularioBinding

class FormularioFragment : Fragment() {

    private var _binding: FragmentFormularioBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFormularioBinding.inflate(inflater, container, false)

        ArrayAdapter
            .createFromResource(
                binding.root.context,
                R.array.tipo_reserva,
                android.R.layout.simple_spinner_item)
            .also {
                adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spTipo.adapter = adapter
            }

        ArrayAdapter
            .createFromResource(
                binding.root.context,
                R.array.cantidad_perros,
                android.R.layout.simple_spinner_item)
            .also {
                    adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spCantidad.adapter = adapter
            }
        return binding.root
    }

}
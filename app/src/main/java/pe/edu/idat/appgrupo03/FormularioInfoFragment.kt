package pe.edu.idat.appgrupo03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.idat.appgrupo03.databinding.FragmentFormularioBinding
import pe.edu.idat.appgrupo03.databinding.FragmentFormularioInfoBinding

class FormularioInfoFragment : Fragment() {
    private var _binding: FragmentFormularioInfoBinding? = null

    private val args by navArgs<FormularioFragmentArgs>()
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFormularioInfoBinding.inflate(inflater, container, false)

        binding.rvListadoReservas.layoutManager = LinearLayoutManager(binding.root.context)
        binding.rvListadoReservas.adapter = AdapterReservas(args.reservas as ArrayList<Reserva>)
        return binding.root
    }

}
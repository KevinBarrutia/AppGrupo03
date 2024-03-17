package pe.edu.idat.appgrupo03

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import pe.edu.idat.appgrupo03.databinding.FragmentFormularioBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class FormularioFragment : Fragment(), View.OnClickListener, AdapterView.OnItemSelectedListener {

    private var _binding: FragmentFormularioBinding? = null
    private val calendar = Calendar.getInstance()
    private val listadoReservas = ArrayList<Reserva>()
    private var tipo: String = ""
    private var cantidad: String = ""

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormularioBinding.inflate(inflater, container, false)

        ArrayAdapter
            .createFromResource(
                binding.root.context,
                R.array.tipo_reserva,
                android.R.layout.simple_spinner_item)
            .also {
                adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spnTipo.adapter = adapter
            }

        ArrayAdapter
            .createFromResource(
                binding.root.context,
                R.array.cantidad_perros,
                android.R.layout.simple_spinner_item)
            .also {
                    adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spnCantidad.adapter = adapter
            }


        binding.etInicio.setOnClickListener(this)
        binding.etFin.setOnClickListener(this)
        binding.btnReservar.setOnClickListener(this)

        binding.spnTipo.onItemSelectedListener = this
        binding.spnCantidad.onItemSelectedListener = this

        return binding.root
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.etInicio -> {
                mostrarDatePicker(binding.etInicio)
                binding.etFin.text.clear()
            }
            R.id.etFin -> if (binding.etInicio.text.isNotEmpty()) {
                val minDate = getDateFormat().parse(binding.etInicio.text.toString())
                mostrarDatePicker(binding.etFin, minDate)
            }
            R.id.btnReservar -> {
                if(validarCampos()) {
                    agregarReserva()
                    val navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main)
                    val action = FormularioFragmentDirections.actionFormularioFragmentToFormularioInfoFragment(listadoReservas)
                    navController.navigate(action)
                    setearCampos()
                }
            }
        }
    }

    private fun agregarReserva() {
        listadoReservas.add(Reserva(tipo, cantidad, binding.etInicio.text.toString(), binding.etFin.text.toString()))
    }

    private fun validarCampos(): Boolean {
        if (tipo.isEmpty()) {
            binding.spnTipo.isFocusableInTouchMode =true
            binding.spnTipo.requestFocus()
        } else if (cantidad.isEmpty()) {
            binding.spnCantidad.isFocusableInTouchMode =true
            binding.spnCantidad.requestFocus()
        } else if (binding.etInicio.text.isEmpty()) {
            binding.etInicio.requestFocus()
        } else if (binding.etFin.text.isEmpty()) {
            binding.etFin.requestFocus()
        } else {
            return true
        }
        return false
    }

    private fun setearCampos() {
        binding.spnTipo.setSelection(0)
        binding.spnCantidad.setSelection(0)
        binding.etInicio.text.clear()
        binding.etFin.text.clear()
    }

    private fun mostrarDatePicker(editText: EditText, minDate: Date? = null) {
        val datePickerDialog = DatePickerDialog(
            binding.root.context,
            {
                _, year, month, day ->
                calendar.set(year, month, day)
                val dateFormat = getDateFormat()
                editText.setText(dateFormat.format(calendar.time))
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH))

        if (minDate != null) {
            datePickerDialog.datePicker.minDate = minDate.time
        }

        datePickerDialog.show()
    }

    private fun getDateFormat(): SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val itemSeleccionado = if(position > 0 ) parent!!.getItemAtPosition(position).toString() else ""
        when (parent!!.id) {
            R.id.spnTipo -> tipo = itemSeleccionado
            R.id.spnCantidad -> cantidad = itemSeleccionado
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}
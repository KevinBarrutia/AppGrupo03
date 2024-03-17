package pe.edu.idat.appgrupo03

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListadoFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ResenaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_listado, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = ResenaAdapter(generateSampleData())
        recyclerView.adapter = adapter
        return view
    }

    private fun generateSampleData(): List<Resena> {
        val data = mutableListOf<Resena>()

        for (i in 1..10) {
            data.add(
                Resena(
                    nombre = "Usuario $i",
                    resena = "Reseña de ejemplo $i",
                    fecha = "Fecha $i",
                    estrellas = (i % 5) + 1
                )
            )
        }

        return data
    }
}
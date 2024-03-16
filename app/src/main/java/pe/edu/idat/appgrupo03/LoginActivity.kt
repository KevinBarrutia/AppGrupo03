package pe.edu.idat.appgrupo03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import pe.edu.idat.appgrupo03.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnIngresar.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnIngresar -> {
                if (validarCampos()) {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                }
            }
        }
    }

    // VALIDACION DE CAMPOS
    private fun validarCampos(): Boolean {

        val id = binding.etId.text.toString()
        val password = binding.etPassword.text.toString()

        if (id.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
            return false
        }
        //validar id : Grupo03
        if (id != "Grupo03") {
            Toast.makeText(this, "ID incorrecto", Toast.LENGTH_SHORT).show()
            return false
        }
        //Validar contraseña: SYS123
        if (password != "SYS123") {
            Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}
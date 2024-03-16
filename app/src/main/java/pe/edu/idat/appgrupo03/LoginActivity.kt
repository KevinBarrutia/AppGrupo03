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

        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
            return false
        }
        val emailRegex = Regex("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,3})+\$")
        if (!email.contains(emailRegex)) {
            Toast.makeText(this, "Por favor ingrese un Email valido", Toast.LENGTH_SHORT).show()
            return false
        }
        if (password.length < 6) {
            Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }
}
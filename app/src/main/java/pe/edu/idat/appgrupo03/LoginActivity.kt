package pe.edu.idat.appgrupo03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
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
            R.id.btnIngresar -> startActivity(
                Intent(
                    applicationContext,
                    MainActivity::class.java
                )
            )
        }
    }
}
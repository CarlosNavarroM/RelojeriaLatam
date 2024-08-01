package com.desafiolatam.desafio3


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.desafiolatam.desafio3.databinding.ActivityDetalleBinding
import com.desafiolatam.desafio3.model.Sucursal


class DetalleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sucursal = intent.getParcelableExtra<Sucursal>("sucursal")

        if (sucursal != null) {
            binding.nombreTextView.text = sucursal.nombre
            binding.direccionTextView.text = sucursal.direccion
            binding.horarioTextView.text = sucursal.horario
            binding.historiaTextView.text = sucursal.historia
            binding.imageView.setImageResource(sucursal.foto)

            binding.direccionTextView.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=${sucursal.direccion}"))
                startActivity(intent)
            }

            binding.compartirButton.setOnClickListener {
                val shareIntent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, sucursal.nombre)
                    type = "text/plain"
                }
                startActivity(Intent.createChooser(shareIntent, "Compartir"))
            }
        }
    }
}

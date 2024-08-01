package com.desafiolatam.desafio3


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.desafiolatam.desafio3.databinding.ActivityMainBinding
import com.desafiolatam.desafio3.model.Sucursal


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sucursales = listOf(
            Sucursal("Cicero Store", "Colosseum, Piazza del Colosseo, 1, 00184 Roma RM, Italy", "Lunes a viernes desde las 9:00 a las 18:30, sábados y domingos abierto desde las 10:30 a las 15:30", R.mipmap.img1, "Sed ut perspiciatis unde omnis iste natus error sit voluptatem..."),
            Sucursal("Li Europan lingues", "Panthéon, Pl. du Panthéon, 75005 Paris, France", "Lunes a viernes desde las 9:00 a las 18:30, fines de semana cerrado", R.mipmap.img2, "Li Europan lingues es membres del sam familie..."),
            Sucursal("Relojeria Kafka", "Prague Astronomical Clock, Staroměstské nám. 1, 110 00 Josefov, Czechia", "Lunes a viernes desde las 9:00 a las 18:30, fines de semana cerrado", R.mipmap.img3, "One morning, when Gregor Samsa woke from troubled dreams..."),
            Sucursal("Love Craft Arts", "Lovecraft Arts & Sciences, 65 Weybosset St, Providence, RI 02903, United States", "Lunes a viernes desde las 9:00 a las 18:30", R.mipmap.img4, "Still another time have I come to a place where it is very difficult to proceed..."),
            Sucursal("The Ancient Mariner", "Public Art: The Ancient Mariner, 11 The Esplanade, Watchet TA23 0AH, United Kingdom", "Lunes a viernes desde las 9:00 a las 18:30", R.mipmap.img5, "Day after day, day after day, We stuck, nor breath nor motion...")
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = SucursalAdapter(sucursales) { sucursal ->
            val intent = Intent(this, DetalleActivity::class.java)
            intent.putExtra("sucursal", sucursal)
            startActivity(intent)
        }
    }
}

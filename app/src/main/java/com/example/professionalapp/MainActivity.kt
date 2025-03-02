package com.example.professionalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var professionalAdapter: ProfessionalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val professionals = listOf(
            Professional(
                name = "María González",
                profession = "Diseñadora Gráfica",
                about = "Especialista en diseño de interfaces y experiencia de usuario.",
                email = "maria.gonzalez@example.com",
                phone = "+50374780996",
                esperiencia = "8 Años",
                imageResId = R.drawable.professional2,
                trabajos = "3.5K"
            ),
            Professional(


                name = "Juan Pérez",
                profession = "Ingeniero de Software",
                about = "Experto en desarrollo de aplicaciones móviles.",
                email = "juan.perez@example.com",
                phone = "+50374780996",
                esperiencia = "3 Años",
                imageResId = R.drawable.professional1,
                trabajos = "300"
            ),
            Professional(
                name = "Carlos López",
                profession = "Arquitecto",
                about = "Diseñador de estructuras modernas y sostenibles.",
                email = "carlos.lopez@example.com",
                phone = "+50374780996",
                esperiencia = "5 Años",
                imageResId = R.drawable.professional3,
                trabajos = "500"
            ),
            Professional(
                name = "Ana Martínez",
                profession = "Médica",
                about = "Especialista en medicina interna y prevención de enfermedades.",
                email = "ana.martinez@example.com",
                phone = "+50374780996",
                esperiencia = "9 Años ",
                imageResId = R.drawable.professional4,
                trabajos = "1.5k"
            ),
            Professional(
                name = "Ana Rodríguez",
                profession = "Abogada",
                about = "Experta en derecho civil y comercial.",
                email = "ana.rodriguez@example.com",
                phone = "+50374780996",
                esperiencia = "2 Años",
                imageResId = R.drawable.professional5,
                trabajos = "400"
            )
        )

        professionalAdapter = ProfessionalAdapter(professionals) { professional, color ->
            ProfessionalDetailActivity.start(this, professional, color)
        }
        recyclerView.adapter = professionalAdapter
    }
}

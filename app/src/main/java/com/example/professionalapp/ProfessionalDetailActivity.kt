package com.example.professionalapp

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class ProfessionalDetailActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_PROFESSIONAL = "extra_professional"
        private const val EXTRA_CARD_COLOR = "card_color"

        fun start(context: Context, professional: Professional, cardColor: Int) {
            val intent = Intent(context, ProfessionalDetailActivity::class.java)
            intent.putExtra(EXTRA_PROFESSIONAL, professional)
            intent.putExtra(EXTRA_CARD_COLOR, cardColor)
            context.startActivity(intent)
        }
    }

    private lateinit var cardViewImageContainer: androidx.cardview.widget.CardView
    private lateinit var detailImageView: ImageView
    private lateinit var detailName: TextView
    private lateinit var detailProfession: TextView
    private lateinit var detailAbout: TextView
    private lateinit var detailEmail: TextView
    private lateinit var detailPhone: TextView
    private lateinit var btnCall: Button
    private lateinit var btnWhatsApp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_professional_detail)

        cardViewImageContainer = findViewById(R.id.cardViewImageContainer)
        detailImageView = findViewById(R.id.detailImageView)
        detailName = findViewById(R.id.detailName)
        detailProfession = findViewById(R.id.detailProfession)
        detailAbout = findViewById(R.id.detailAbout)
        detailEmail = findViewById(R.id.detailEmail)
        detailPhone = findViewById(R.id.detailPhone)
        btnCall = findViewById(R.id.btnCall)
        btnWhatsApp = findViewById(R.id.btnWhatsApp)

        val professional = intent.getSerializableExtra(EXTRA_PROFESSIONAL) as Professional
        val cardColor = intent.getIntExtra(EXTRA_CARD_COLOR, 0xFFFFFFFF.toInt())

        cardViewImageContainer.setCardBackgroundColor(cardColor)

        detailImageView.setImageResource(professional.imageResId)
        detailName.text = professional.name
        detailProfession.text = professional.profession
        detailAbout.text = professional.about
        detailEmail.text = "Correo: ${professional.email}"
        detailPhone.text = "Teléfono: ${professional.phone}"

        btnCall.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:${professional.phone}")
            startActivity(dialIntent)
        }

        btnWhatsApp.setOnClickListener {
            val mensaje = "Me gustaría Contratar tus servicios: ${professional.name} Espero tu respuesta."
            val phoneNumber = professional.phone.replace("+", "").replace(" ", "")
            val url = "https://api.whatsapp.com/send?phone=$phoneNumber=&text=$mensaje"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
                startActivity(intent)
        }
    }
}
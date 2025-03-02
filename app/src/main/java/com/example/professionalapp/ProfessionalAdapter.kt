package com.example.professionalapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ProfessionalAdapter(
    private val professionals: List<Professional>,
    private val itemClick: (Professional, Int) -> Unit
) : RecyclerView.Adapter<ProfessionalAdapter.ProfessionalViewHolder>() {

    private lateinit var colorList: List<Int>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfessionalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_professional, parent, false)

        if (!::colorList.isInitialized) {
            colorList = listOf(
                ContextCompat.getColor(parent.context, R.color.colorCard1),
                ContextCompat.getColor(parent.context, R.color.colorCard2),
                ContextCompat.getColor(parent.context, R.color.colorCard3),
                ContextCompat.getColor(parent.context, R.color.colorCard4),
                ContextCompat.getColor(parent.context, R.color.colorCard5)
            )
        }
        return ProfessionalViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfessionalViewHolder, position: Int) {
        val professional = professionals[position]
        holder.bind(professional)

        val color = colorList[position % colorList.size]
        holder.setCardBackgroundColor(color)

        holder.itemView.setOnClickListener { itemClick(professional, color) }
    }

    override fun getItemCount(): Int = professionals.size

    class ProfessionalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cardView: CardView = itemView.findViewById(R.id.cardViewProfessional)
        private val imageView: ImageView = itemView.findViewById(R.id.imageView)
        private val tvName: TextView = itemView.findViewById(R.id.tvName)
        private val tvProfession: TextView = itemView.findViewById(R.id.tvProfession)
        private val tvesperiencia: TextView = itemView.findViewById(R.id.tvesperiencia1)
        private val tvtrabajos: TextView = itemView.findViewById(R.id.tvtrabajos1)

        fun bind(professional: Professional) {
            imageView.setImageResource(professional.imageResId)
            tvName.text = professional.name
            tvProfession.text = professional.profession
            tvesperiencia.text = professional.esperiencia
            tvtrabajos.text = professional.trabajos
        }

        fun setCardBackgroundColor(color: Int) {
            cardView.setCardBackgroundColor(color)
        }
    }
}



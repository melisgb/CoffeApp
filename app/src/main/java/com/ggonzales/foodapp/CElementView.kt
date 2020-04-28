package com.ggonzales.foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import kotlinx.android.synthetic.main.activity_c_element_view.*

class CElementView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c_element_view)

        val elementExtras = intent.extras
        celementNameTextView.text = elementExtras!!.getString("name")
        celementDescTextView.text = elementExtras!!.getString("desc")
        celementImageView.setImageResource(elementExtras!!.getInt("image"))
        if(elementExtras.getString("hasLongClicked")== "Yes"){
            celementNameTextView.setTextColor(resources.getColor(R.color.attention))
        }
        title = getString(R.string.detallestexto)
    }
}
